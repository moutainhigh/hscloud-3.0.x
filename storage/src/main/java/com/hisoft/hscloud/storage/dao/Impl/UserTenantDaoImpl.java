/* 
* 文 件 名:  UserTenantDaoImpl.java 
* 版    权:  hiSoft Technologies Co., Ltd. Copyright 2011-2012,  All rights reserved 
* 描    述:  <描述> 
* 修 改 人:  lihonglei 
* 修改时间:  2013-5-15 
* 跟踪单号:  <跟踪单号> 
* 修改单号:  <修改单号> 
* 修改内容:  <修改内容> 
*/ 
package com.hisoft.hscloud.storage.dao.Impl; 

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import com.hisoft.hscloud.storage.dao.UserTenantDao;
import com.hisoft.hscloud.storage.entity.UserTenant;

/** 
 * <一句话功能简述> 
 * <功能详细描述> 
 * 
 * @author  lihonglei 
 * @version  [版本号, 2013-5-15] 
 * @see  [相关类/方法] 
 * @since  [产品/模块版本] 
 */
@Repository
public class UserTenantDaoImpl extends HibernateDao<UserTenant, Long>  implements UserTenantDao {
    @Override
    public UserTenant findUniqueBy(String userName) {
        return this.findUniqueBy("userName", userName);
    }
}
