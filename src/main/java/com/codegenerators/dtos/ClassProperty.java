package com.codegenerators.dtos;

import com.codegenerators.utils.StringUtil;

public class ClassProperty {
	
	private String comment;
	
	private Boolean requried;
	
	private String propertyID;
	
	private String name;
	
	private String type;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getRequried() {
		return requried;
	}

	public void setRequried(Boolean requried) {
		this.requried = requried;
	}

	public String getPropertyID() {
		return propertyID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtil.toUpperCaseFirstOne(name.trim());
		this.propertyID = StringUtil.toLowerCaseFirstOne(this.name);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ClassProperty [comment=" + comment + ", requried=" + requried + ", propertyID=" + propertyID + ", name="
				+ name + ", type=" + type + "]";
	}
	
}
