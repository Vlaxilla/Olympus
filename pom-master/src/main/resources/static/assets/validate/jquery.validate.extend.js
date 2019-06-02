/*this is basic form validation using for validation person's basic information author:Clara Guo data:2017/07/20*/
$(document).ready(function(){
	$.validator.setDefaults({
		  submitHandler: function(form) {
		 		form.submit();
		}
	});
	//phone only：(^\d{15}$)|(^\d{17}([0-9]|X)$)
	jQuery.validator.addMethod("isPhone",function(value,element){
		var length = value.length;
		var phone=/^1[3|4|5|7|8][0-9]\d{8}$/;
		return this.optional(element)||(length == 11 && phone.test(value));
	},"phone number");
	//phone verfiy
	jQuery.validator.addMethod("isTel",function(value,element){
		var tel = /^(0\d{2,3}-)?\d{7,8}$/g;//区号3,4位,号码7,8位
		return this.optional(element) || (tel.test(value));
	},"phone number agin");
	//userName
	jQuery.validator.addMethod("isName",function(value,element){
		var name=/^[\u4e00-\u9fa5]{2,6}$/;
		return this.optional(element) || (name.test(value));
	},"name letter");

	jQuery.validator.addMethod("isUserName",function(value,element){
		var userName=/^[a-zA-Z0-9]{2,13}$/;
		return this.optional(element) || (userName).test(value);
	},'letter ');

	//validator
	jQuery.validator.addMethod("isIdentity",function(value,element){
		var id= /^(\d{15}$|^\d{18}$|^\d{17}(\d|X))$/;
		return this.optional(element) || (id.test(value));
	},"A");
	//校验出生日期
	jQuery.validator.addMethod("isBirth",function(value,element){
		var birth = /^(19|20)\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/;
		return this.optional(element) || (birth).test(value);
	},"DOB 2000-01-01");
	//
	jQuery.validator.addMethod("isdiff",function(){
		var p1=$("#pwdOld").val();
		var p2=$("#pwdNew").val();
		if(p1==p2){
			return false;
		}else{
			 return true;
		}
		});
	//correction
	jQuery.validator.addMethod("issame",function(){
		var p3=$("#confirm_password").val();
		var p4=$("#pwdNew").val();
		if(p3==p4){
			return true;
		}else{
			 return false;
		}
		});
	//
	$("#basicInfoForm").validate({
		errorElement:'span',
		errorClass:'help-block error-mes',
		rules:{
			name:{
				required:true,
				isName:true
			},
			sex:"required",
			birth:"required",
            mobile:{
				required:true,
				isPhone:true
			},
			email:{
				required:true,
				email:true
			}
		},
		messages:{
			name:{
				required:"name",
				isName:"name"
			},
			sex:{
				required:"sex"
			},
			birth:{
				required:"DOB"
			},
            mobile:{
				required:"mobile ",
				isPhone:"phone agian"
			},
			email:{
				required:"email",
				email:"email verify"
			}
		},

		errorPlacement:function(error,element){
			element.next().remove();
			element.closest('.gg-formGroup').append(error);
		},

		highlight:function(element){
			$(element).closest('.gg-formGroup').addClass('has-error has-feedback');
		},
		success:function(label){
			var el = label.closest('.gg-formGroup').find("input");
			el.next().remove();
			label.closest('.gg-formGroup').removeClass('has-error').addClass("has-feedback has-success");
			label.remove();
		},
		submitHandler:function(form){
			alert("save!");
		}
	});

	//modifyPwd
	$("#modifyPwd").validate({
		onfocusout: function(element) { $(element).valid()},
		 debug:false, //
		 onkeyup:false, //
		rules:{
			pwdOld:{
				required:true,
				minlength:1
			},
            pwdNew:{
			   required:true,
			   minlength:1,
			   isdiff:true,
			   //issame:true,
		   },
			confirm_password:{
			  required:true,
			  minlength:1,
			  issame:true,
			}

		   },
		messages:{
			 	pwdOld : {
					 required:'input',
					 minlength:$.validator.format('no less 1')
				},
            	pwdNew:{
				   required:'required',
				   minlength:$.validator.format('no less 1'),
				   isdiff:'cannot repeat',

			   },
				confirm_password:{
				   required:'required',
				   minlength:$.validator.format('no less 1'),
				   issame:'same Password',
				}

		},
		errorElement:"mes",
		errorClass:"gg-star",
		errorPlacement: function(error, element)
		{
			element.closest('.gg-formGroup').append(error);

		}
	});
});
