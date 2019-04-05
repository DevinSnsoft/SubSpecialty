function tiaozhuan(){
//	window.androidJsStub.sendCurrentUserInform();
//androidSetValuesJson(null);
	androidSetValuesJson();
}
/*从移动沈农中获取账号密码*/
/*function androidSetValuesJson(param){
	param = JSON.parse(param);
	sessionStorage.setItem('account',param.account);*/
function androidSetValuesJson(){	
	sessionStorage.setItem('account',"2017101001");
	sessionStorage.setItem('password',"ssssssss");
	var tranData = {};
	/*var account = param.account;
	alert(account+"开始报名");*/
	tranData['account'] = sessionStorage.getItem('account');
	tranData['password'] = sessionStorage.getItem('password');
	mui.ajax('Login',{
		data:tranData,
		dataType:'json',
		type:'post',
		timeout:'60000',
		success:function(data){
//		if(data.code == 2){
				//登录成功,教师
//				var k1=document.getElementsByName("k1")[0];
//				var k2=document.getElementsByName("k1")[1];
//				if(k1.checked){
//					window.location.href="choose.jsp";
//				}else if(k2.checked){
//					window.location.href="adminload.jsp";
//				}
//				window.location.href="adminload.jsp";
//			} else if(data.code == 3){
				//登录成功，学生
				window.location.href="choose.jsp";
//		}else {
//				mui.alert(data.msg);
//			}		
		},
		error:function(xhr, type, errorThrow) {
			mui.alert(errorThrow, "错误", "OK", null);
		}
	})
}



