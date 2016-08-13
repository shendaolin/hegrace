
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
				
				$.get("getJjryLngLats.html", function(data){
					
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
				        //alert(self.alljjry[item.id].position);
				        marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
				            offset: new AMap.Pixel(20, 5),//修改label相对于maker的位置
				            content: item.xm + "(" + item.dh + ")"
				        });
				        self.alljjry[""+item.id] = {
				        		"marker" : marker,
				        		"position" : marker.getPosition(),
				        		"ryid" : item.ryid,
				        		"jlid" : item.jlid
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
			$.get("getQJJLLngLats.html", function(data){
				
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
			        	$.get("getQJJLInfomation.html", {"qjid" : item.id}, function(list){
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
				        		content += " <a href=\"#\" class=\"btn red mini\">关闭</a>";
				        		content += " <a href=\"#\" class=\"btn green mini\">取消</a>";
				        		content += " <a href=\"#\" class=\"btn blue mini\">查看详细</a>";
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
					        	$.ajaxSetup({  async : false  }); 
					        	$.get("automatic.html", {"ryid":ryids.join(","), "qjid" : item.id}, function(){
					        		jQuery.each(distance, function(i, json){
					        			self.alljjry[json.key].jjyzt = '1';
						        	})
					        	})
					        	$.ajaxSetup({  async : true}); 
					        	
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
		}
	}
}();
