/* 
* 文 件 名:  DataService.java 
* 版    权:  hiSoft Technologies Co., Ltd. Copyright 2011-2012,  All rights reserved 
* 描    述:  <描述> 
* 修 改 人:  lihonglei 
* 修改时间:  2013-2-20 
* 跟踪单号:  <跟踪单号> 
* 修改单号:  <修改单号> 
* 修改内容:  <修改内容> 
*/ 
package com.hisoft.hscloud.common.service; 

import java.util.List;

import com.hisoft.hscloud.common.entity.City;
import com.hisoft.hscloud.common.entity.Province;


/** 
 * 数据字典服务
 * <功能详细描述> 
 * 
 * @author  lihonglei 
 * @version  [版本号, 2013-2-20] 
 * @see  [相关类/方法] 
 * @since  [产品/模块版本] 
 */
public interface DataService {

    public List<Province> getProvinceList();
        
    public String getProvinceCode(String regionCode);
    
    public List<City> getCityList(String provinceCode);
}
