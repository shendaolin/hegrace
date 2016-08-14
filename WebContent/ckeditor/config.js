/*
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	config.toolbar = 'Full';
    config.toolbar_Full = [

       ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],

       '/',

       ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],

        ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],

        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],

        ['Link','Unlink','Anchor'],

       ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],

       '/',

        ['Styles','Format','Font','FontSize'],

        ['TextColor','BGColor']

    ];
	config.filebrowserBrowseUrl = '../ckfinder/ckfinder.html' ;  
    config.filebrowserImageBrowseUrl = '../ckfinder/ckfinder.html?type=Images' ;  
    config.filebrowserFlashBrowseUrl = '../ckfinder/ckfinder.html?type=Flash' ;  
	config.filebrowserUploadUrl = "../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files";
	config.filebrowserImageUploadUrl = "../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images";
	config.filebrowserFlashUploadUrl = "../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash";
	config.filebrowserWindowWidth = "580";
	config.filebrowserWindowHeight = "600";
	config.language = "zh-cn";
	config.width = "100%";
	config.height = "300px";
	config.toolbarCanCollapse = false;		// 工具栏收缩
	config.removePlugins = 'elementspath';	// 文本框地下的body p
	config.resize_enabled = false;			// 文本框拖动改变大小
	config.font_names = '宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names;
};
