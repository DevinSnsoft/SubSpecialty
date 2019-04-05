package cn.snsoft.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;


/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 (c) 2016
 * 
 * @author Mr. Soldier
 * 
 * @version 1.0
 * 
 * @date 2016年7月8日 下午6:09:51
 * 
 * @Description TODO
 *	json数据格式转化工具类
 */
public class ProrocalUtils {
	
	/**
	 * 将请求中的json数据转为HashMap对象，并将password解密
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static Map<String,String> getRequestParams(HttpServletRequest request)
			throws IOException{
		if(request == null)
			return null;
		HashMap<String,String> reqParams = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		BufferedReader reader = request.getReader();
		StringBuffer buffer = new StringBuffer("");
		String temp;
		while((temp = reader.readLine()) != null){
			buffer.append(temp);
		}
		reader.close();
		String acceptjson = buffer.toString();
		if(!StringUtils.isBlank(acceptjson)){
			if(acceptjson.contains("=")){
				if(acceptjson.contains("&")){
					String[] map = acceptjson.split("&");
					for(String item : map){
						reqParams.put(item.split("=")[0], item.split("=")[1]);
					}
				}
			} else {
				//json字符串转化为JSONObject对象
				JSONObject jo = JSONObject.fromObject(acceptjson);
				@SuppressWarnings("unchecked")
				Iterator<Object> it = jo.keys();
				while(it.hasNext()){
					String key = (String) it.next();
					String value = jo.getString(key);
					reqParams.put(key, value);
				}
			}
		}
		return reqParams;
	}
	
	
}
