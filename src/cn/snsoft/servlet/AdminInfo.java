package cn.snsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import cn.snsoft.dao.ApplyDao2;
import cn.snsoft.utils.AllConstant;
import cn.snsoft.utils.JsonUtils;

/**
 * Servlet implementation class AdminInfo
 */
@WebServlet("/AdminInfo")
public class AdminInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "请求异常！"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//返回结果
				String result = "";
				//解析请求中的参数
				HashMap<String, String> param = JsonUtils.getRequestParams(request);
				//参数校验
				if(StringUtils.isEmpty(param.get("account"))){
					result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "管理员账号不能为空！");
				}else{
					try {
						//调用dao
						ApplyDao2 ad = new ApplyDao2();
						HashMap<String, Object> res = ad.getAdminInfo(param);
						if(res != null){
							result = JsonUtils.jsonResponse(res, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
						}else{
							result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "该管理员不存在！");
						}
					} catch (SQLException e) {
						result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "操作失败！");
						e.printStackTrace();
					}
				}
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(result);	
	}

}
