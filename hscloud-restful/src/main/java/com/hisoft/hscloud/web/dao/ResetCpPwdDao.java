/* 
* 文 件 名:  ResetCpPwdDao.java 
* 版    权:  hiSoft Technologies Co., Ltd. Copyright 2011-2012,  All rights reserved 
* 描    述:  <描述> 
* 修 改 人:  lihonglei 
* 修改时间:  2013-8-21 
* 跟踪单号:  <跟踪单号> 
* 修改单号:  <修改单号> 
* 修改内容:  <修改内容> 
*/ 
package com.hisoft.hscloud.web.dao; 

/** 
 * <重置控制面板密码> 
 * <功能详细描述> 
 * 
 * @author  lihonglei 
 * @version  [版本号, 2013-8-21] 
 * @see  [相关类/方法] 
 * @since  [产品/模块版本] 
 */
public interface ResetCpPwdDao {
    
    /**
     * <查询creatflag>
    * <功能详细描述> 
    * @param vmId
    * @return 
    * @see [类、类#方法、类#成员]
     */
    public String queryCreateflagByVmId(String vmId);

}
