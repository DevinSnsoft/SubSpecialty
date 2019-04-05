package cn.snsoft.service;

import java.util.List;

import cn.snsoft.dao.ApplyDao;
import cn.snsoft.bean.EnrollBean;
import cn.snsoft.bean.PageBean;
import cn.snsoft.bean.QueryInfo;
import cn.snsoft.bean.QueryResult;
//import cn.snsoft.service.BusinessService;

//
/*
public class BusinessServiceImpl implements BusinessService {

	private ApplyDao dao = new ApplyDao();
	
	@Override
	public void addCustomer(Customer c) {
		dao.add(c);
	}
	
	
	@Override
	public void updateCustomer(Customer c){
		dao.update(c);
	}
	
	@Override
	public void deleteCustomer(String id){
		dao.delete(id);
	}
	
	@Override
	public Customer findCustomer(String id){
		return dao.find(id);
	}
	
	@Override
	public List<Customer> getAllCustomer(){
		return dao.getAll();
	}
	
	public PageBean pageQuery(QueryInfo queryInfo){
		//����dao��ȡ��ҳ�����
		QueryResult qr = dao.pageQuery(queryInfo.getStartindex(), queryInfo.getPagesize());
		
		//���dao��ѯ������ҳ����ʾ��Ҫ��pagebean
		PageBean bean = new PageBean();
		bean.setCurrentpage(queryInfo.getCurrentpage());
		bean.setList(qr.getList());
		bean.setPagesize(queryInfo.getPagesize());
		bean.setTotalrecord(qr.getTotalrecord());
		
		return bean;
	}
}
*/