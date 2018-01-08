package com.codegenerators.dtos;

import java.util.Date;
import java.util.List;

import com.codegenerators.utils.DateUtil;

public class ClassStructure {
	
	private String className;
	
	private String packageName;
	
	private String createUser;
	
	private String createDate;
	
	private String createTime;
	
	private String comment;
	
	private List<ClassProperty> properties;
	
	public ClassStructure() {
		super();
		Date now = new Date();
		this.createDate = DateUtil.DateToString(now, "MM/dd/yy");
		this.createTime = DateUtil.DateToString(new Date(), "hh:mm a");
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className.trim();
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getCreateUser() {
		return createUser == null ? "" : createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public String getComment() {
		return comment == null ? "" : comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<ClassProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<ClassProperty> properties2) {
		this.properties = properties2;
	}

	@Override
	public String toString() {
		return "ClassStructure [className=" + className + ", packageName=" + packageName + ", createUser=" + createUser
				+ ", createDate=" + createDate + ", createTime=" + createTime + ", comment=" + comment + ", properties="
				+ properties + "]";
	}


}
