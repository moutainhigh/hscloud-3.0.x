package com.hisoft.hscloud.web.service; 

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonObject;
import com.hisoft.hscloud.web.util.MD5Util;


public class BasicServiceTest {
    
    @Test
    public void testMd5() throws Exception {
        System.out.println("test");
        String str = MD5Util.encode("1aba8356ee9d3bdf61180ccb62322a5d");
        System.out.println(str);
    }
    
    
    @Test
    public void testDecode() {
        String str="{\"success\":true,\"resultObject\":'[{\"datacenter\":\"北京双线机房\",\"description\":\"CPU： 1颗n内存： 512Mn硬盘： 20G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 4.0 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-01-14 00:00:00.0\",\"expiredon\":\"2015-01-31 23:59:59.0\",\"feeType\":\"id:4287,period:12,price:1250.00\",\"id\":187,\"os_info\":\"osname:window_2003_32bit_20G,osid:90;osname:CentOS_5.6_32_20G,osid:12;osname:windows_2003_32_20G(环境版),osid:72;osname:Centos_6.4_64_20G,osid:117\",\"scname\":\"云计算服务器-H1型\"},{\"datacenter\":\"北京双线机房\",\"description\":\"CPU： 2颗n内存： 1Gn硬盘： 50G(SAS)n系统空间： 20Gn带宽： 独享10Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 4.0 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-01-14 00:00:00.0\",\"expiredon\":\"2015-01-14 23:59:59.0\",\"feeType\":\"id:5286,period:12,price:1860.00\",\"id\":188,\"os_info\":\"osname:window_2003_32bit_20G,osid:90;osname:CentOS_5.6_32_20G,osid:12;osname:windows_2003_32_20G(环境版),osid:72;osname:Centos_6.4_64_20G,osid:117\",\"scname\":\"云计算服务器-H2型\"},{\"datacenter\":\"北京双线机房\",\"description\":\"CPU： 4颗n内存： 1.5Gn硬盘： 100G(SAS)n系统空间： 20Gn带宽： 独享10Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 4.0 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-01-14 00:00:00.0\",\"expiredon\":\"2015-01-31 23:59:59.0\",\"feeType\":\"id:5287,period:12,price:2485.00\",\"id\":189,\"os_info\":\"osname:window_2003_32bit_20G,osid:90;osname:CentOS_5.6_32_20G,osid:12;osname:windows_2003_32_20G(环境版),osid:72;osname:Centos_6.4_64_20G,osid:117\",\"scname\":\"云计算服务器-H3型\"},{\"datacenter\":\"北京双线机房\",\"description\":\"CPU： 4颗n内存： 2Gn硬盘： 120G(SAS)n系统空间： 20Gn带宽： 独享10Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 4.0 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-01-14 00:00:00.0\",\"expiredon\":\"2015-01-31 23:59:59.0\",\"feeType\":\"id:5288,period:12,price:3389.00\",\"id\":190,\"os_info\":\"osname:window_2003_32bit_20G,osid:90;osname:CentOS_5.6_32_20G,osid:12;osname:windows_2003_32_20G(环境版),osid:72;osname:Centos_6.4_64_20G,osid:117;osname:Windows_2008R2_64_20G,osid:77\",\"scname\":\"云计算服务器-H5型\"},{\"datacenter\":\"北京双线机房\",\"description\":\"CPU： 4颗n内存： 3Gn硬盘： 230G(SAS)n系统空间： 20Gn带宽： 独享10Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 4.0 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-01-14 00:00:00.0\",\"expiredon\":\"2015-01-31 23:59:59.0\",\"feeType\":\"id:4291,period:12,price:4818.00\",\"id\":191,\"os_info\":\"osname:window_2003_32bit_20G,osid:90;osname:CentOS_5.6_32_20G,osid:12;osname:windows_2003_32_20G(环境版),osid:72;osname:Centos_6.4_64_20G,osid:117;osname:Windows_2008R2_64_20G,osid:77\",\"scname\":\"云计算服务器-K3型\"},{\"datacenter\":\"北京双线机房\",\"description\":\"CPU： 4颗n内存： 4Gn硬盘： 320G(SAS)n系统空间： 20Gn带宽： 独享10Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 4.0 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-01-14 00:00:00.0\",\"expiredon\":\"2015-01-14 23:59:59.0\",\"feeType\":\"id:5289,period:12,price:6689.00\",\"id\":192,\"os_info\":\"osname:window_2003_32bit_20G,osid:90;osname:CentOS_5.6_32_20G,osid:12;osname:Windows_2008R2_64_20G,osid:77;osname:windows_2003_32_20G(环境版),osid:72;osname:Centos_6.4_64_20G,osid:117\",\"scname\":\"云计算服务器-K4型\"},{\"datacenter\":\"北京双线机房\",\"description\":\"CPU： 4颗n内存： 5Gn硬盘： 400G(SAS)n系统空间： 20Gn带宽： 独享10Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 4.0 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-01-14 00:00:00.0\",\"expiredon\":\"2015-01-14 23:59:59.0\",\"feeType\":\"id:5290,period:12,price:7689.00\",\"id\":193,\"os_info\":\"osname:window_2003_32bit_20G,osid:90;osname:CentOS_5.6_32_20G,osid:12;osname:Windows_2008R2_64_20G,osid:77;osname:windows_2003_32_20G(环境版),osid:72;osname:Centos_6.4_64_20G,osid:117\",\"scname\":\"云计算服务器-K5型\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 2颗n内存： 1Gn硬盘： 50G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-27 23:59:59.0\",\"feeType\":\"id:5320,period:12,price:1860.00\",\"id\":557,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器H2型-(DG)\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 4颗n内存： 1.5Gn硬盘： 100G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-30 23:59:59.0\",\"feeType\":\"id:5321,period:12,price:2485.00\",\"id\":558,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2003_32_20G_HK(环境版),osid:113;osname:windows_2008_64_20G_HK,osid:109\",\"scname\":\"云计算服务器H3型-(DG)\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 4颗n内存： 2Gn硬盘： 120G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5313,period:12,price:3389.00\",\"id\":559,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器H5型-(DG)\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 4颗n内存： 3Gn硬盘： 230G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5314,period:12,price:4818.00\",\"id\":560,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器K3型-(DG)\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 4颗n内存： 4Gn硬盘： 320G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5315,period:12,price:6689.00\",\"id\":561,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器K4型-(DG)\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 4颗n内存： 5Gn硬盘： 400G(SAS)n系统空间： 20Gn带宽： 独享10Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5316,period:12,price:7689.00\",\"id\":562,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器K5型-(DG)\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 4颗n内存： 6Gn硬盘： 600G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 4.0 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5317,period:12,price:8700.00\",\"id\":563,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器K6型-(DG)\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 4颗n内存： 8Gn硬盘： 800G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5318,period:12,price:12950.00\",\"id\":564,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器E1型-(DG)\"},{\"datacenter\":\"广东东莞电信机房\",\"description\":\"CPU： 4颗n内存： 16Gn硬盘： 1500G(SAS)n系统空间： 20Gn带宽： 独享5Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-07-12 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5319,period:12,price:19670.00\",\"id\":565,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器E2型-(DG)\"},{\"datacenter\":\"香港电信机房\",\"description\":\"CPU： 2颗n内存： 1Gn硬盘： 100G(SAS)n系统空间： 20Gn带宽： 独享3Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005在系统盘中）\",\"effectiveon\":\"2013-05-29 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5330,period:12,price:3000.00\",\"id\":566,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器--HK1型\"},{\"datacenter\":\"香港电信机房\",\"description\":\"CPU： 4颗n内存： 2Gn硬盘： 180G(SAS)n系统空间： 20Gn带宽： 独享3Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-04-19 00:00:00.0\",\"expiredon\":\"2014-04-19 23:59:59.0\",\"feeType\":\"id:5331,period:12,price:5335.00\",\"id\":567,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器--HK2型\"},{\"datacenter\":\"香港电信机房\",\"description\":\"CPU： 4颗n内存： 3Gn硬盘： 240G(SAS)n系统空间： 20Gn带宽： 独享3Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-04-19 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5332,period:12,price:7500.00\",\"id\":568,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器--HK3型\"},{\"datacenter\":\"香港电信机房\",\"description\":\"CPU： 4颗n内存： 4Gn硬盘： 350G(SAS)n系统空间： 20Gn带宽： 独享3Mn网卡： 千兆n独立公网IP地址： 1个n（注：环境版中带有 .NET 3.5 , IIS6.0 ,FTP,MSSQL 2005；另MSSQL 2005装在系统盘中）\",\"effectiveon\":\"2013-05-29 00:00:00.0\",\"expiredon\":\"2015-12-31 23:59:59.0\",\"feeType\":\"id:5333,period:12,price:10000.00\",\"id\":569,\"os_info\":\"osname:windows_2003_32_20G_HK,osid:107;osname:centos_5.6_32_20G_HK,osid:108;osname:windows_2008_64_20G_HK,osid:109;osname:windows_2003_32_20G_HK(环境版),osid:113\",\"scname\":\"云计算服务器--HK4型\"}]'}";
        JSONObject jsonObject = JSONObject.fromObject(str);
        Object obj = jsonObject.get("success");
        System.out.println(obj);
        obj = jsonObject.get("resultObject");
        JSONArray jsonArray = JSONArray.fromObject(obj);
        Object obj1 = jsonArray.get(0);
        System.out.println(((JSONObject)obj1).get("description"));
      //  System.out.println(((JSONObject)((JSONArray)obj).get(0)).get(\"test\"));
    }
}
