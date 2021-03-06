/* 
* 文 件 名:  VpdcRenewalService.java 
* 版    权:  hiSoft Technologies Co., Ltd. Copyright 2011-2012,  All rights reserved 
* 描    述:  <描述> 
* 修 改 人:  ljg 
* 修改时间:  2013-6-6 
* 跟踪单号:  <跟踪单号> 
* 修改单号:  <修改单号> 
* 修改内容:  <修改内容> 
*/ 
package com.hisoft.hscloud.vpdc.ops.service; 

import java.util.Map;

import org.springside.modules.orm.Page;

import com.hisoft.hscloud.common.util.HsCloudException;
import com.hisoft.hscloud.vpdc.ops.entity.VpdcRenewal;

/** 
 * <一句话功能简述> 
 * <功能详细描述> 
 * 
 * @author  ljg 
 * @version  [版本号, 2013-6-6] 
 * @see  [相关类/方法] 
 * @since  [产品/模块版本] 
 */
public interface VpdcRenewalService {
	/**
	 * <保存续订业务数据> 
	* <功能详细描述> 
	* @param vpdcRenewal
	* @return
	* @throws HsCloudException 
	* @see [类、类#方法、类#成员]
	 */
	public long saveVpdcRenewal(VpdcRenewal vpdcRenewal) throws HsCloudException;
	/**
	 * <删除续订业务数据> 
	* <功能详细描述> 
	* @param referenceId
	* @return
	* @throws HsCloudException 
	* @see [类、类#方法、类#成员]
	 */
	public boolean deleteVpdcRenewalByReferenceId(long referenceId) throws HsCloudException;
	/**
	 * <查询续订业务数据记录> 
	* <功能详细描述> 
	* @param referenceId
	* @return
	* @throws HsCloudException 
	* @see [类、类#方法、类#成员]
	 */
	public VpdcRenewal getVpdcRenewalByReferenceId(long referenceId) throws HsCloudException;
	/**
	 * <查询续订业务数据列表> 
	* <功能详细描述> 
	* @param page
	* @param field
	* @param fieldValue
	* @param query
	* @param userId
	* @return
	* @throws HsCloudException 
	* @see [类、类#方法、类#成员]
	 */
	public Page<VpdcRenewal> findVpdcRenewal(Page<VpdcRenewal> page,String field, Object fieldValue,String query,long userId) throws HsCloudException;
    /**
     * <保存续订业务数> 
    * <功能详细描述> 
    * @param condition 
    * @see [类、类#方法、类#成员]
     */
	public void saveVpdcRenewal(Map<String, Object> condition);
	/**
	 * <修改续订业务数> 
	* <功能详细描述> 
	* @param condition 
	* @see [类、类#方法、类#成员]
	 */
    public void updateVpdcRenewal(Map<String, Object> condition);
}
