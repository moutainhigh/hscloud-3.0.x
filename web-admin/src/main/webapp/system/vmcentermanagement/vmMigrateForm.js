/******************************vmMigrateForm******************************************/
//params = getCookie("lang");
//i18n.set({
//	lang : params,
//	path : '../../resources'
//});
Ext.Loader.setConfig({
	enabled : true
});
var AutMigrateFlag = true;
var v_mask = null;//遮罩层
var hostName='';
var vmCPUUsed=Ext.create('Ext.form.field.Text', {
	name : 'vmCPUUsed'
});
var vmMemoryUsed=Ext.create('Ext.form.field.Text', {
	name : 'vmMemoryUsed'
});
var vmDiskUsed=Ext.create('Ext.form.field.Text', {
	name : 'vmDiskUsed'
});
var vmZoneCode=Ext.create('Ext.form.field.Text', {
	name : 'vmZoneCode'
});
//手动迁移时节点列表模板
var vmMigrateNodeModel = Ext.define('vmMigrateNodeModel', {
	extend : 'Ext.data.Model',
	fields : [ 'hostId','hostName','nodeAliases',
	           'cpuRate','ramRate','diskRate',
	           'cpuCore','memory','disk',
	           'cpuUsage','memoryUsage','diskUsage'
	          ]
});
//手动迁移时节点列表Store
var vmMigrateFindNodeStore = Ext.create('Ext.data.Store', {
	model : 'vmMigrateNodeModel',
	proxy :new Ext.data.proxy.Ajax({
		type : 'ajax',
		url : path + '/../monitoring/monitor!getAllHostUsage.action',
		reader : {
			type : 'json',
			root : 'resultObject.result',
			totalProperty : 'resultObject.totalCount'
		},
		listeners:{
			exception:function(reader, response, error, eOpts){
				ajaxException(reader, response, error, eOpts );
			}
		}
	}),
	autoLoad : false//true
});
//节点列表Grid
var vmMigrateFindNodeGrid = Ext.create('Ext.grid.Panel', {
	store : vmMigrateFindNodeStore,
	hideHeaders : true,
	layout : 'fit',
	columns : [ {
		header : i18n._('node'),
		dataIndex : 'nodeAliases',
		flex : 1.1
	} ],
	listeners:{
		itemclick :function(nodeGrid,record, item, index, e, eOpts){
			ManualMigratePanel.setVisible(true);
			ManualMigratePictureCompent.setVisible(false);
			AutMigratePictureCompent.setVisible(false);
			var recordId = record.get('hostId');
			hostName = record.get('hostName');
			var hostOldCPUUsage=record.get('cpuUsage')/100;
			var hostOldMemoryUsage=record.get('memoryUsage')/100;
			var hostOldDiskUsage=record.get('diskUsage')/100;
			
			var hostNewCPUUsage=hostOldCPUUsage+vmCPUUsed.getValue()/record.get('cpuCore')*record.get('cpuRate');
			var hostNewMemoryUsage=hostOldMemoryUsage+vmMemoryUsed.getValue()/record.get('memory')*record.get('ramRate');
			var hostNewDiskUsage=hostOldDiskUsage+vmDiskUsed.getValue()/record.get('disk')*record.get('diskRate');
			
			vmMigrateCPUOldChart.updateProgress(hostOldCPUUsage);
			vmMigrateMEMOldChart.updateProgress(hostOldMemoryUsage);
			vmMigrateDiskOldChart.updateProgress(hostOldDiskUsage);
			
			vmMigrateCPUNewChart.updateProgress(hostNewCPUUsage);
			vmMigrateMEMNewChart.updateProgress(hostNewMemoryUsage);
			vmMigrateDiskNewChart.updateProgress(hostNewDiskUsage);
			
			vmMigrateCPUOldLabel.setText(Math.round(record.get('cpuUsage'))+'%');
			vmMigrateMemoryOldLabel.setText(Math.round(record.get('memoryUsage'))+'%');
			vmMigrateDiskOldLabel.setText(Math.round(record.get('diskUsage'))+'%');
			
			vmMigrateCPUNewLabel.setText(Math.round(hostNewCPUUsage*100)+'%');
			vmMigrateMemoryNewLabel.setText(Math.round(hostNewMemoryUsage*100)+'%');
			vmMigrateDiskNewLabel.setText(Math.round(hostNewDiskUsage*100)+'%');
		}
	}	
});
var vmMigrateCPUOldLabel = Ext.create('Ext.form.Label', {
	width : 100,
	text: ''
});
var vmMigrateMemoryOldLabel = Ext.create('Ext.form.Label', {
	width : 100,
	text: ''
});
var vmMigrateDiskOldLabel = Ext.create('Ext.form.Label', {
	width : 100,
	text: ''
});
var vmMigrateCPUNewLabel = Ext.create('Ext.form.Label', {
	width : 100,
	text: ''
});
var vmMigrateMemoryNewLabel = Ext.create('Ext.form.Label', {
	width : 100,
	text: ''
});
var vmMigrateDiskNewLabel = Ext.create('Ext.form.Label', {
	width : 100,
	text: ''
});
//迁移前CPU比值
var vmMigrateCPUOldChart = Ext.create('Ext.ProgressBar', {
	//renderTo : Ext.getBody(),
	width : 200,
	border : '2 2 2 1',
	cls:'custom .x-progress-inner',
	style : {
		borderColor : 'gray',
		borderStyle : 'solid',
		background : '#bcbcbc'
	}
});
//迁移后CPU比值
var vmMigrateCPUNewChart = Ext.create('Ext.ProgressBar', {
	//renderTo : Ext.getBody(),
	width : 200,
	border : '2 2 2 1',
	cls:'custom .x-progress-inner',
	style : {
		borderColor : 'gray',
		borderStyle : 'solid',
		background : '#bcbcbc'
	}
});
//迁移前Memory比值
var vmMigrateMEMOldChart = Ext.create('Ext.ProgressBar', {
	//renderTo : Ext.getBody(),
	width : 200,
	border : '2 2 2 1',
	cls:'custom .x-progress-inner',
	style : {
		borderColor : 'gray',
		borderStyle : 'solid',
		background : '#bcbcbc'
	}
});
//迁移后Memory比值
var vmMigrateMEMNewChart = Ext.create('Ext.ProgressBar', {
	//renderTo : Ext.getBody(),
	width : 200,
	border : '2 2 2 1',
	cls:'custom .x-progress-inner',
	style : {
		borderColor : 'gray',
		borderStyle : 'solid',
		background : '#bcbcbc'
	}
});
//迁移前Disk比值
var vmMigrateDiskOldChart = Ext.create('Ext.ProgressBar', {
	//renderTo : Ext.getBody(),
	width : 200,
	border : '2 2 2 1',
	cls:'custom .x-progress-inner',
	style : {
		borderColor : 'gray',
		borderStyle : 'solid',
		background : '#bcbcbc'
	}
});
//迁移后Disk比值
var vmMigrateDiskNewChart = Ext.create('Ext.ProgressBar', {
	//renderTo : Ext.getBody(),
	width : 200,
	border : '2 2 2 1',
	cls:'custom .x-progress-inner',
	style : {
		borderColor : 'gray',
		borderStyle : 'solid',
		background : '#bcbcbc'
	}
});
//手动迁移Panel
var ManualMigratePanel = Ext.create('Ext.panel.Panel', {
	// autoHeight:true,
	autoScroll : true,	
	layout : 'vbox',
	frame : true,
	width : '100%',
	items : [ {
		xtype : 'label',
		text : i18n._('Physical machine utilization rate')//物理机使用率：
	}, {
		xtype : 'fieldcontainer',
		layout : 'hbox',
		items : [ {
			xtype : 'label',
			text : i18n._('CPU')+':',
			width : 40
		}, vmMigrateCPUOldChart,vmMigrateCPUOldLabel ]
	}, {
		xtype : 'fieldcontainer',
		layout : 'hbox',
		items : [ {
			xtype : 'label',
			text : i18n._('MEM')+':',
			width : 40
		}, vmMigrateMEMOldChart,vmMigrateMemoryOldLabel ]
	}, {
		xtype : 'fieldcontainer',
		layout : 'hbox',
		items : [ {
			xtype : 'label',
			text : i18n._('DISK')+':',
			width : 40
		}, vmMigrateDiskOldChart, vmMigrateDiskOldLabel]
	}, {
		xtype : 'label',
		text : i18n._('Expected resource allocation')//计划资源分配情况
	}, {
		xtype : 'fieldcontainer',
		layout : 'hbox',
		items : [ {
			xtype : 'label',
			text : i18n._('CPU')+':',
			width : 40
		}, vmMigrateCPUNewChart,vmMigrateCPUNewLabel ]
	}, {
		xtype : 'fieldcontainer',
		layout : 'hbox',
		items : [ {
			xtype : 'label',
			text : i18n._('MEM')+':',
			width : 40
		}, vmMigrateMEMNewChart ,vmMigrateMemoryNewLabel]
	}, {
		xtype : 'fieldcontainer',
		layout : 'hbox',
		items : [ {
			xtype : 'label',
			text : i18n._('DISK')+':',
			width : 40
		}, vmMigrateDiskNewChart ,vmMigrateDiskNewLabel]
	} ]	
});
//自动迁移示意图
var AutMigratePictureCompent=Ext.create('Ext.Component', {
	//width : 400,
	//height :200,
	border : false,
	autoEl : {
		tag : 'img', // 指定为img标签
		src : 'images/autoMigratePic.jpg' // 指定url路径								
	}
});
//手动迁移示意图
var ManualMigratePictureCompent=Ext.create('Ext.Component', {
	//width : 400,
	//height :200,
	border : false,
	autoEl : {
		tag : 'img', // 指定为img标签
		src : 'images/manualMigratePic.jpg' // 指定url路径								
	}
});
//自动迁移按钮
var AutMigrateButton=Ext.create('Ext.button.Button', {
	text : "<img src='images/autoMigrate.png'/>"+i18n._('AutomaticMigration'),//1.自动迁移
	width : 80,
	handler : function() {
		AutMigrateFlag = true;		
		ManualMigratePictureCompent.setVisible(false);
		AutMigratePictureCompent.setVisible(true);
		ManualMigratePanel.setVisible(false);
	}
});

//手动迁移容器
var ManualMigrateButton = Ext.create('Ext.button.Button', {	
	text : "<img src='images/manualMigrate.png'/>"+i18n._('ManualMigration'),//2.手动迁移
	width : 80,
	handler : function() {
		AutMigrateFlag = false;	
		vmMigrateFindNodeStore.load({params:{'zoneCode':vmZoneCode.getValue()}});
		MigrateLeftPanel.add(vmMigrateFindNodeGrid);		
		ManualMigratePictureCompent.setVisible(true);
		AutMigratePictureCompent.setVisible(false);
		ManualMigratePanel.setVisible(false);
	}	
});
//左侧容器
var MigrateLeftPanel=Ext.create('Ext.panel.Panel', {
	layout:'vbox',
	border : false,
	items:[AutMigrateButton, ManualMigrateButton]
	
});
//右侧容器
var MigrateRightPanel=Ext.create('Ext.panel.Panel', {
	layout:'fit',
	border : false,
	items:[AutMigratePictureCompent,ManualMigratePictureCompent,ManualMigratePanel]	//
});
// 迁移VMForm
var migrateVMForm = Ext.create('Ext.form.Panel', {
	frame : true,
	autoScroll : true,
	// height :800,
	// title: 'Form Fields',
	// width: 250,
	bodyPadding : 5,
	fieldDefaults : {
		labelAlign : 'left',
		labelWidth : 60,
		anchor : '100%'
	},
	items : [ 
	{
		xtype : 'label',
		text : i18n._('Please select the migration scheme')//请选择迁移方案
	},
	{
		xtype : 'panel',
		layout : 'column',
		items:[
		{
			xtype :'panel',
			width : '20%',
			items : [ MigrateLeftPanel ]
		},
		{
			xtype :'panel',
			width : '80%',
			items : [ MigrateRightPanel ]
		}
		]
	} 
	],//ManualMigratePanel 	
	buttons : [ {
		text : i18n._('OK'),
		handler : function() {
			// 遮罩层
			v_mask = new Ext.LoadMask(Ext
					.getBody(), {
				msg : i18n._('please wait'),
				removeMask : true								
			});	
			// 自动迁移
			if (AutMigrateFlag == true) {
				v_mask.show();
				Ext.Ajax.request({
					url : path + '/../ops/ops!autoMigrateVm.action',
					method : 'POST',
					params : 'id=' + vmid,
					success : function(form, action) {
						v_mask.hide();
						var obj = Ext.decode(form.responseText);
						if (obj == null || obj.success == null) {
							Ext.MessageBox.show({
								title : i18n._('errorNotice'),
								msg : i18n._('returnNull'),
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.ERROR
							});// INFO,QUESTION,WARNING,ERROR
							return;
						}
						if (!obj.success) {
							Ext.MessageBox.show({
								title : i18n._('errorNotice'),
								msg : obj.resultMsg,
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING
							});
							return;
						}
						if (obj.resultCode=='00000') {
							Ext.MessageBox.show({
								title : i18n._('notice'),
								msg : i18n._('operationMessage'),//迁移成功
								icon : Ext.MessageBox.INFO,
								buttons : Ext.MessageBox.OK,
								fn: reLoadData
							});							
						}						
					},
					failure : function(form, action) {
						v_mask.hide();
						Ext.MessageBox.show({
							title : i18n._('errorNotice'),
							msg : i18n._('operateFail'),
							buttons : Ext.MessageBox.OK,
							icon : Ext.MessageBox.WARNING,
							fn: reLoadData
						});
					}
				});				
			}
			// 手动迁移
			if (AutMigrateFlag == false) {
				v_mask.show();
				Ext.Ajax.request({
					url : path + '/../ops/ops!manualMigrateVm.action',
					method : 'POST',
					params : {
						'id':vmid,
						'hostName':hostName
					},
					success : function(form, action) {
						v_mask.hide();
						var obj = Ext.decode(form.responseText);
						if (obj == null || obj.success == null) {
							Ext.MessageBox.show({
								title : i18n._('errorNotice'),
								msg : i18n._('returnNull'),
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.ERROR
							});// INFO,QUESTION,WARNING,ERROR
							return;
						}
						if (!obj.success) {
							Ext.MessageBox.show({
								title : i18n._('errorNotice'),
								msg : obj.resultMsg,
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING
							});
							return;
						}
						if (obj.resultCode=='00000') {
							Ext.MessageBox.show({
								title : i18n._('notice'),
								msg : i18n._('operationMessage'),//迁移成功
								icon : Ext.MessageBox.INFO,
								buttons : Ext.MessageBox.OK,
								fn: reLoadData
							});							
						}						
					},
					failure : function(form, action) {
						v_mask.hide();
						Ext.MessageBox.show({
							title : i18n._('errorNotice'),
							msg : i18n._('operateFail'),
							buttons : Ext.MessageBox.OK,
							icon : Ext.MessageBox.WARNING,
							fn: reLoadData
						});
					}
				});
			}
			migrateVMForm.getForm().reset();
			createVMWin.remove(migrateVMForm,false);
			createVMWin.hide();
		}
	}, {
		text : i18n._('Cancel'),
		handler : function() {
			vmRefreshReset();//刷新设置重置
			migrateVMForm.getForm().reset();
			createVMWin.remove(migrateVMForm,false);
			createVMWin.hide();
		}
	} ]
});
//操作完成后点确认刷新数据操作
function reLoadData(btn){
	vmRefreshReset();//刷新设置重置
	instanceStore.load();
};
function getCookie(name) {
	var arr = document.cookie
			.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null)
		return unescape(arr[2]);
	return null;
};
function getQuery(name) {
	var reg = new RegExp("" + name + "=([^&?]*)");
	var keyVal = window.location.search.substr(1).match(reg);
	// alert(keyVal[1]);
	if (keyVal != null)
		return unescape(keyVal[1]);
	return null;
};
function getStringIP(iIP){
	var ip = "";  
    var temp = 0; 
	for (var i = 3; i >= 0; i--) {  
		temp = iIP/Math.pow(256, i) % 256; 
		temp=parseInt(temp);
		if (i == 3) {			
			ip = ip + temp;			
		} else {  
			ip = ip + "." + temp;			
		}  
	}   
	return ip;
};