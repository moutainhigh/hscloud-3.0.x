/* 
* 文 件 名:  O_IP_NETWORK.java 
* 版    权:  hiSoft Technologies Co., Ltd. Copyright 2011-2012,  All rights reserved 
* 描    述:  <描述> 
* 修 改 人:  lihonglei 
* 修改时间:  2014-2-13 
* 跟踪单号:  <跟踪单号> 
* 修改单号:  <修改单号> 
* 修改内容:  <修改内容> 
*/ 
package com.pactera.hscloud.hscloudhandler.bo; 

/** 
 * <一句话功能简述> 
 * <功能详细描述> 
 * 
 * @author  lihonglei 
 * @version  [版本号, 2014-2-13] 
 * @see  [相关类/方法] 
 * @since  [产品/模块版本] 
 */
public class O_IP_NETWORK extends O_IP {
    private String network_id;
    private Long id;

    public String getNetwork_id() {
        return network_id;
    }

    public void setNetwork_id(String network_id) {
        this.network_id = network_id;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
