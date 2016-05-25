package com.cmt.util;

import java.util.List;

import com.cmt.pojo.User;

public class UserPageUtil {
	private int pageSize;//每页多少条记录
	private int currentPage;//当前第几页
	private int totalRecord;//一共多少条记录
	private int totalPage;//一共多少页记录
	private List<User>dataList;//所有的数据
	private int fromIndex;
	private int toIndex ;
	
	public UserPageUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public  UserPageUtil(int pageNum, int pageSize, List<User>sourceList) {
//		if(sourceList == null)
//			return;
		//总记录条数
		dataList=sourceList;
		System.out.println("datalist size : " + dataList.size());
		this.totalRecord = sourceList.size();
		//每页显示多少条记录
		this.pageSize = pageSize;
		//获取总记录数
		this.totalPage = this.totalRecord/this.pageSize;
		if(this.totalRecord % this.pageSize != 0)
			++this.totalPage;
		
		//当前第几页数据
		if(this.totalPage < pageNum){
			this.currentPage = this.totalPage;
		}else{
			this.currentPage = pageNum;
		}
		
		//起始索引
		fromIndex = this.pageSize*(this.currentPage -1);
		
		//结束索引
		if(this.pageSize*this.currentPage> this.totalRecord){
			toIndex = this.totalRecord;
		}else{
			toIndex= this.pageSize*this.currentPage;
		}
	}
	
	public List<User> getPage(int pageNum){
		System.out.println("datalist size : " + dataList.size());
		this.totalRecord = dataList.size();
		//每页显示多少条记录
		this.pageSize = pageSize;
		//获取总记录数
		this.totalPage = this.totalRecord/this.pageSize;
		if(this.totalRecord % this.pageSize != 0)
			++this.totalPage;
		
		//当前第几页数据
		if(this.totalPage < pageNum){
			this.currentPage = this.totalPage;
		}else{
			this.currentPage = pageNum;
		}
		
		//起始索引
		fromIndex = this.pageSize*(this.currentPage -1);
		
		//结束索引
		if(this.pageSize*this.currentPage> this.totalRecord){
			toIndex = this.totalRecord;
		}else{
			toIndex= this.pageSize*this.currentPage;
		}
		return dataList.subList(fromIndex, toIndex);
	}
	
	public UserPageUtil(int pageSize, int currentPage, int totalRecord, int totalPage,
			List<User> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<User> getDataList() {
		return dataList;
	}
	public void setDataList(List<User> dataList) {
		this.dataList = dataList;
	}
	
	
	@Override
	public String toString() {
		return "Pager [pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", totalRecord=" + totalRecord + ", totalPage=" + totalPage
				+ ", dataList=" + dataList + "]";
	}
}
