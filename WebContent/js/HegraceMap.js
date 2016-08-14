
var HegraceMap = function(){
	return {
		mapObj : null,
		infoWindow : null,
		markerJjrys : [],
		markerQjjls : [],
		alljjry:{},
		allqjjl:{},
		init : function() {
			var position = new AMap.LngLat(120.121082,30.230878);// 创建中心点坐标
			this.mapObj = new AMap.Map("page-content", {
				center : position,
				level : 17
			});// 创建地图实例
			this.mapObj.setFitView();
			this.infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(0, -30)});
			this.getQjjlLngLatsInterval();
			this.getJjryLngLatsInterval();
		},
		
		getJjryLngLatsInterval : function(){
			
			var self = this;
			var getJjryLngLats = function(){
				
				$.get("getJjryLngLats.htm", function(data){
					
					if(self.markerJjrys.length > 0){
						self.mapObj.remove(self.markerJjrys);
						self.markerJjrys = [];
					}
					self.alljjry = {};
					var rows = data.rows;
					$(rows).each(function(i, item){
				        var marker = new AMap.Marker({
				        	icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
				            position:item.zb.split(",")
				        });
				        marker.setMap(self.mapObj);
				        marker.on('click', function(e){
				        	
				        	var content = "";
				        	$.get("getJjryInfomation.htm", {"jjyid" : item.id}, function(list){
				        			$.each(list.rows, function(key, xtSsjjyDto){
				        				if(key == 0){
				        					content += "<div>急救员："+xtSsjjyDto.xm+"("+xtSsjjyDto.dh+")</div>"
				        					if(xtSsjjyDto.sbmc){
				        						content += "<div>设备名称："+xtSsjjyDto.sbmc+"</div>"
				        					}
				        					content += "<div>身份类型："+xtSsjjyDto.sflx+"</div>"
				        					content += "<div>类别："+xtSsjjyDto.lb+"</div>"
				        					content += "<br/>";
				        				}
				        				if(xtSsjjyDto.qjid){
				        					content += "<div>正在救助："+xtSsjjyDto.qjxm+"("+xtSsjjyDto.qjdh+")</div>"
				        				}
				        			});
					        		self.infoWindow.setContent(content);
						        	self.infoWindow.open(self.mapObj, marker.getPosition());
				        	})
				        });
				        
				        var content = item.xm + "(" + item.dh + ")";
				        	if(item.sbmc){
				        		content += "<br/>设备:"+item.sbmc;
				        	}
				        
				        marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
				            offset: new AMap.Pixel(20, 0),//修改label相对于maker的位置
				            content: content
				        });
				        self.alljjry[""+item.id] = {
				        		"marker" : marker,
				        		"position" : marker.getPosition(),
				        		"ryid" : item.ryid,
				        		"jlid" : item.jlid,
				        		"sbmc" : item.sbmc,
				        		"xm" : item.xm,
				        		"dh" : item.dh,
				        		"id" : item.id
				        };
				        self.markerJjrys.push(marker);
					});
					
				});
			}
			getJjryLngLats();
			setInterval(function() {
				getJjryLngLats();
			}, "60000");
		},
		getQJJLLngLats : function(){
			var self = this;
			$.get("getQJJLLngLats.htm", function(data){
				
				if(self.markerQjjls.length > 0){
					self.mapObj.remove(self.markerQjjls);
					self.markerQjjls = [];
				}
				self.allqjjl = {};
				var rows = data.rows;
				$(rows).each(function(i, item){
					if(!item.zb) return;
			        var marker = new AMap.Marker({
			        	icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_r.png",
			            position:item.zb.split(",")
			        });
			        marker.on('click', function(e){
			        	
			        	var content = "";
			        	$.get("getQJJLInfomation.htm", {"qjid" : item.id}, function(list){
				        		var ztStyle = {
										"0" : "未接受",
										"1" : "已接受",
										"2" : "已驳回",
										"3" : "已处理"
								}
			        			$.each(list.rows, function(key, xtQjjlDto){
			        				if(key == 0){
			        					content += "<div>参赛者："+xtQjjlDto.xm+"("+xtQjjlDto.dh+")</div>"
			        					content += "<div>事件名称："+xtQjjlDto.sjmc+"</div>"
			        					content += "<div>事件描述："+xtQjjlDto.ms+"</div>"
			        					content += "<br/>";
			        				}
			        				if(xtQjjlDto.jjyxm){
			        					content += "<div>["+ztStyle[xtQjjlDto.jjyzt]+"]救护员："+xtQjjlDto.jjyxm+"("+xtQjjlDto.jjydh+")</div>"
			        				}
			        			});
				        		content += "<br/><div>";
				        		content += " <a href=\"javascript:;\" class=\"btn green mini\" onclick=\"HegraceMap.close('"+item.id+"')\">完成</a>";
				        		content += " <a href=\"javascript:;\" class=\"btn red mini\" onclick=\"HegraceMap.cancel('"+item.id+"')\">取消</a>";
				        		
				        		content += " <a class=\"btn green mini\" href=\"javascript:;\" data-toggle=\"dropdown\">";
				        		content += " <i class=\"icon-user\"></i> 手工分配";
				        		content += " <i class=\"icon-angle-down\"></i>";
				        		content += " </a>";
				        		content += " <ul class=\"dropdown-menu\" style='top:100%;left:112px;margin-top:-34px;height:200px;width:100%;overflow:auto;'>";
				        		 if(self.alljjry){
				        			 jQuery.each(self.alljjry, function(key, jjry){
				        				 if(jjry.jlid)return;
				        				 content += " <li>";
				        				 content += " <a href=\"javascript:;\" onclick=\"HegraceMap.allocation('"+jjry.id+"','"+item.id+"')\"><i class=\" icon-user\"></i> "+jjry.xm+"("+jjry.dh+")";
				        				 if(jjry.sbmc){
				        				 content += " <br/><i class=\" icon-plus-sign\"></i> 设备("+jjry.sbmc+")";
				        				 }
				        				 content += " </a></li>";
				        			 });
				        		 }
				        		content += " </ul>";
				        		content += "</div>"
				        		self.infoWindow.setContent(content);
					        	self.infoWindow.open(self.mapObj, marker.getPosition());
			        	})
			        });
			        
				        if(self.alljjry){
				        	var distance = [];
				        	jQuery.each(self.alljjry, function(key, jjry){
			        			if(!jjry.jlid && !item.jjyzt){
			        				distance.push({"key" : key, "ryid":jjry.ryid, "jl":marker.getPosition().distance(jjry.position)})
			        			}
				        	})
				        	
				        	distance = distance.sort(function(a, b){  
				                return a.jl-b.jl;  
				            });  	
				        	
					        	distance = distance.slice(0,2);
				        	
					        	var ryids = [];
				        	jQuery.each(distance, function(i, json){
				        		ryids.push(json.ryid);
					        })
					        
				        	if(ryids.length > 0){
					        	$.ajaxSetup({async : false  }); 
					        	$.get("automatic.htm", {"ryid":ryids.join(","), "qjid" : item.id}, function(){
					        		jQuery.each(distance, function(i, json){
					        			self.alljjry[json.key].jjry = '1';
						        	})
					        	})
					        	$.ajaxSetup({async : true}); 
					        	
				        	}
				        }
			        
			        marker.setMap(self.mapObj);
			        marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
			            offset: new AMap.Pixel(20, 5),//修改label相对于maker的位置
			            content: item.xm + "(" + item.dh + ")"
			        });
			        self.allqjjl[""+item.id] = {
			        		"marker" : marker,
			        		"position" : marker.getPosition()
			        };
			        self.markerQjjls.push(marker);
			        
				});
				
			});
		},
		
		getQjjlLngLatsInterval : function(){
			var self = this;
			setInterval(function() {
				self.getQJJLLngLats();
			}, "30000");
		},
		
		close : function(qjid){
			var self = this;
			if(confirm("完成任务吗？")){
				$.get("closeQjjl.htm",{"qjid" : qjid}, function(){
					var marker = self.allqjjl[""+qjid].marker;
					self.mapObj.remove(marker);
					delete self.allqjjl[""+qjid];
					self.infoWindow && self.infoWindow.close();
				});
			}else{
			       return false;
			}
		},
		
		cancel : function(qjid){
			if(confirm("取消任务吗？")){
				$.get("cancelQjjl.htm",{"qjid" : qjid}, function(){
					var marker = self.allqjjl[""+qjid].marker;
					self.mapObj.remove(marker);
					delete self.allqjjl[""+qjid];
					self.infoWindow && self.infoWindow.close();
				});
			}else{
			       return false;
			}
		},
		
		allocation : function(jjryid, qjid){
			var self = this;
			if(confirm("确认分配吗？")){
				$.get("allocation.htm",{"qjid" : qjid, "jjryid" : jjryid}, function(){
					self.alljjry[""+jjryid].jlid = "1";
					AMap.event.trigger(self.allqjjl[""+qjid].marker,"click");
				});
			}else{
			       return false;
			}
		}
	}
}();
