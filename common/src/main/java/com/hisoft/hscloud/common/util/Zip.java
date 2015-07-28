package com.hisoft.hscloud.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

/**
 * path 必须以 / 结尾 
 * @author Minggang
 *
 */
public class Zip {

	private String path;//压缩到路径
	private final String ZIPSUFFIX = ".zip";
	private final String ZIPNAME = "ZipFile";
	private ZipFile zipFile;
	private ZipOutputStream zipOut; // 压缩Zip
	private int bufSize; // size of bytes
	private byte[] buf;
	private int readedBytes;
	// 用于压缩中。要去除的绝对父路路径，目的是将绝对路径变成相对路径。
	private String deleteAbsoluteParent;

	/**
	 * 构造方法。默认缓冲区大小为512字节。
	 */
	public Zip() {
		this.init(512,null);
	}

	/**
	 * 构造方法。默认缓冲区大小为512字节。
	 * @param path  压缩/解压 路径
	 */
	public Zip(String path){
		this.init(512,path);
	}
	
	/**
	 * 构造方法。默认缓冲区大小为512字节。
	 * @param bufSize
	 * @param path   压缩/解压 路径
	 */
	public Zip(int bufSize,String path){
		this.init(512,path);
	}
	
	/**
	 * 初始化，
	 * @param bufSize 默认 512
	 * @param path    压缩/解压 路径
	 */
	private void init(int bufSize,String path) {
		if(null == path || "" == path){
			this.path = getClass().getResource("/").getPath();
		}else{
			this.path = getClass().getResource("/").getPath()+ path;
		}
		this.bufSize = bufSize;
		this.buf = new byte[this.bufSize];
		deleteAbsoluteParent = null;
	}

	/**
	 * 压缩文件夹内的所有文件和目录。
	 * 
	 * @param zipDirectory
	 *            需要压缩的文件夹名
	 */
	public void doZip(String zipDirectory) {
		File zipDir = new File(zipDirectory);
		String fileName =zipDir.getName();
		if(!zipDir.isDirectory()){
			if(fileName.lastIndexOf(".")>1){
				fileName = fileName.substring(0,fileName.lastIndexOf("."));
			}
		}
		doZip(new File[] { zipDir },fileName);
	}

	/**
	 * 压缩多个文件或目录。可以指定多个单独的文件或目录。而 <code>doZip(String zipDirectory)</code>
	 * 则直接压缩整个文件夹。
	 * 
	 * @param files
	 *            要压缩的文件或目录组成的<code>File</code>数组。
	 * @param zipFileName
	 *            压缩后的zip文件名，如果后缀不是".zip"， 自动添加后缀".zip"。
	 */
	public void doZip(File[] files, String zipFileName) {
		// 未指定压缩文件名，默认为"ZipFile"
		if (zipFileName == null || zipFileName.equals(""))
			zipFileName = this.ZIPNAME;

		// 添加".zip"后缀
		if (!zipFileName.endsWith(this.ZIPSUFFIX))
			zipFileName += this.ZIPSUFFIX;

		try {
			this.zipOut = new ZipOutputStream(new BufferedOutputStream(
					new FileOutputStream(this.path+zipFileName)));
			this.zipOut.setEncoding("gbk");
			zipFiles(files, this.zipOut, true);
			this.zipOut.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * 压缩文件和目录。由doZip()调用
	 * 
	 * @param files
	 *            要压缩的文件
	 * @param zipOut
	 *            zip输出流
	 * @param isAbsolute
	 *            是否是要去除的绝对路径的根路径。因为zipFiles()
	 *            会递归地被调用，所以只用deleteAbsoluteParent不行。必须用isAbsolute来指明
	 *            zipFiles()是第一次调用，而不是后续的递归调用。即如果要压缩的路径是
	 *            E:\temp，那么第一次调用时，isAbsolute=true，则deleteAbsoluteParent会记录
	 *            要删除的路径就是E:\ ，当压缩子目录E:\temp\folder时，isAbsolute=false，
	 *            再递归调用zipFiles()时，deleteAbsoluteParent仍然是E:\ 。从而保证了
	 *            将E:\temp及其子目录均正确地转化为相对目录。这样压缩才不会出错。不然绝对 路径E:\也会被写入到压缩文件中去。
	 */
	private void zipFiles(File[] files, ZipOutputStream zipOut,
			boolean isAbsolute) throws IOException {

		for (File file : files) {
			if (file == null)
				continue; // 空的文件对象

			// 删除绝对父路径
			if (file.isAbsolute()) {
				if (isAbsolute) {
					deleteAbsoluteParent = file.getParentFile()
							.getAbsolutePath();
					deleteAbsoluteParent = appendSeparator(deleteAbsoluteParent);
				}
			} else
				deleteAbsoluteParent = "";

			if (file.isDirectory()) {// 是目录
				zipFolder(file, zipOut);
			} else {// 是文件
				zipFile(file, zipOut);
			}
		}
	}

	/**
	 * 压缩文件或空目录。由compressFiles()调用。
	 * 
	 * @param file
	 *            需要压缩的文件
	 * @param zipOut
	 *            zip输出流
	 */
	public void zipFile(File file, ZipOutputStream zipOut) throws IOException {

		String fileName = file.toString();

		/* 去除绝对父路径。 */
		if (file.isAbsolute())
			fileName = fileName.substring(deleteAbsoluteParent.length());
		if (fileName == null || fileName == "")
			return;

		/*
		 * 因为是空目录，所以要在结尾加一个"/"。 不然就会被当作是空文件。 ZipEntry的isDirectory()方法中,目录以"/"结尾.
		 * org.apache.tools.zip.ZipEntry : public boolean isDirectory() { return
		 * getName().endsWith("/"); }
		 */
		if (file.isDirectory())
			fileName = fileName + "/";// 此处不能用"\\"

		zipOut.putNextEntry(new ZipEntry(fileName));

		// 如果是文件则需读;如果是空目录则无需读，直接转到zipOut.closeEntry()。
		if (file.isFile()) {
			FileInputStream fileIn = new FileInputStream(file);
			while ((this.readedBytes = fileIn.read(this.buf)) > 0) {
				zipOut.write(this.buf, 0, this.readedBytes);
			}
			fileIn.close();
		}

		zipOut.closeEntry();
	}

	/**
	 * 递归完成目录文件读取。由compressFiles()调用。
	 * 
	 * @param dir
	 *            需要处理的文件对象
	 * @param zipOut
	 *            zip输出流
	 */
	private void zipFolder(File dir, ZipOutputStream zipOut) throws IOException {

		File[] files = dir.listFiles();

		if (files.length == 0)// 如果目录为空，则单独压缩空目录。
			zipFile(dir, zipOut);
		else
			// 如果目录不为空,则分别处理目录和文件.
			zipFiles(files, zipOut, false);
	}

	/**
	 * 解压指定zip文件。
	 * 
	 * @param unZipFileName
	 *            需要解压的zip文件名
	 */
	public void unZip(String unZipFileName) {
		FileOutputStream fileOut;
		File file;
		InputStream inputStream;

		try {
			this.zipFile = new ZipFile(unZipFileName);

			for (Enumeration<ZipEntry> entries = this.zipFile.getEntries(); entries
					.hasMoreElements();) {

				ZipEntry entry = (ZipEntry) entries.nextElement();
				file = new File(entry.getName());

				if (entry.isDirectory()) {// 是目录，则创建之
					file.mkdirs();
				} else {// 是文件
						// 如果指定文件的父目录不存在,则创建之.
					File parent = file.getParentFile();
					if (parent != null && !parent.exists()) {
						parent.mkdirs();
					}

					inputStream = zipFile.getInputStream(entry);

					fileOut = new FileOutputStream(file);
					while ((this.readedBytes = inputStream.read(this.buf)) > 0) {
						fileOut.write(this.buf, 0, this.readedBytes);
					}
					fileOut.close();

					inputStream.close();
				}
			}
			this.zipFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * 给文件路径或目录结尾添加File.separator
	 * 
	 * @param fileName
	 *            需要添加路径分割符的路径
	 * @return 如果路径已经有分割符，则原样返回，否则添加分割符后返回。
	 */
	private String appendSeparator(String path) {
		if (!path.endsWith(File.separator))
			path += File.separator;
		return path;
	}

	/**
	 * 解压指定zip文件。
	 * 
	 * @param unZipFile
	 *            需要解压的zip文件对象
	 */
	public void unZip(File unZipFile) {
		unZip(unZipFile.toString());
	}

	/**
	 * 设置压缩或解压时缓冲区大小。
	 * 
	 * @param bufSize
	 *            缓冲区大小
	 */
	public void setBufSize(int bufSize) {
		this.bufSize = bufSize;
	}
	
}