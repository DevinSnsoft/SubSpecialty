package cn.snsoft.test;

import java.util.Calendar;

/** 
copyright :神农大学生软件创新中心 版权所有（c） 2017
 * @author  王江江_River: 
 * @date 创建时间：2018年3月29日 下午7:50:34 
 * @version 1.0 
 * @parameter  
 * @deprecated
 * @return  
 */
public class Test {
public static void main(String[] args) {
	Calendar c = Calendar.getInstance();//可以对每个时间域单独修改   

	int year = c.get(Calendar.YEAR);  
	System.out.println(String.valueOf(year - 1));
}
}

