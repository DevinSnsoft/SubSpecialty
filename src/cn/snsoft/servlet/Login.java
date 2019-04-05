package cn.snsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.snsoft.dao.ApplyDao;
import cn.snsoft.dao.ApplyDao2;
import cn.snsoft.utils.AllConstant;
import cn.snsoft.utils.ConnectToJWC;
import cn.snsoft.utils.JsonUtils;
import cn.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 返回结果
		String res = "";
		try {
			Map<String, String> reqparam = ProrocalUtils.getRequestParams(request);
			String studentId = reqparam.get("account");
			String password = reqparam.get("password");
			request.getSession().setAttribute("studentId", studentId);
			
			//获取当前的年份
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);  
			ConnectToJWC connect = new ConnectToJWC();
			ApplyDao ad = new ApplyDao();
			ApplyDao2 apply = new ApplyDao2();
			HashMap<String, String> param = new HashMap<String, String>();
			HashMap<String, String> paramadmin = new HashMap<String, String>();
			param.put("studentId", studentId);
			paramadmin.put("account", studentId);
			HashMap<String, Object> result = ad.getStudentInfo(param);
			HashMap<String, Object> resultAdmin = apply
					.getAdminInfo(paramadmin);	
			if(connect.checkVPNAccount(studentId, password)){
				//账号密码验证通过
				if('5'==studentId.charAt(4)){
					//第五位为数字5，则为教师账号
					if(resultAdmin != null){
						request.getSession().setAttribute("account", studentId);
						request.getSession().setAttribute("password", password);
						res = JsonUtils.jsonResponse(null, 2,
								"登录成功！");
					} else {
						//当前教师账号无权限
						res = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "当前教师账号无权限！");
					}
				} else if(studentId.startsWith(String.valueOf(year - 1))){
					//以2016开头，并且第五位不为数字5，则为2016级学生
					if(result != null){
						res = JsonUtils.jsonResponse(null, 3,
								"登录成功！");
						request.getSession().setAttribute("studentId", studentId);
						request.getSession().setAttribute("password", password);
//						System.out.println("Session中学号:"+request.getSession().getAttribute("studentId"));
					} else {
						//当前学生账号无权限
						res = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "非大一新生,不能分流!");
					}
				}
			}/* else {
				res = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "用户名或密码错误！！！！");
			}*/
		} catch (SQLException e) {
			res = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "操作失败！");
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(res);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
