

window.androidJsStub.sendCurrentUserInform();
/*从移动沈农中获取账号密码*/
function androidSetValuesJson(param){
	param = JSON.parse(param);
	sessionStorage.setItem('account',param.account);
	sessionStorage.setItem('password',"ssssssss");
}



