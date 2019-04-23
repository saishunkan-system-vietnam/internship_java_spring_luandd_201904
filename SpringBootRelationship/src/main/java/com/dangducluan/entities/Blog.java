package com.dangducluan.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blog {
	private Integer blogId;
	private String blogName;
	private Date createdOn;
	private List<Post> listPost = new ArrayList<Post>();
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public List<Post> getListPost() {
		return listPost;
	}
	public void setListPost(List<Post> listPost) {
		this.listPost = listPost;
	}
	
}
