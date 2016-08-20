var Login = function () {
    
    return {
        //main function to initiate the module
        init: function () {
        	
          
        	$('.login-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	                dlm: {
	                    required: true,
						minlength:5
	                },
	                dlmm: {
	                    required: true
	                }
	            },

	            messages: {
	                dlm: {
	                    required: "用户名必填.",
						minlength: "用户名长度必须大于等于5位."
	                },
	                dlmm: {
	                    required: "密码必填."
	                }
	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	            	$('.login-form').submit();
	            }
	        });

	        $('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.login-form').validate().form()) {
	                	$('.login-form').submit();
	                }
	                return false;
	            }
	        });
           

        }

    };

}();