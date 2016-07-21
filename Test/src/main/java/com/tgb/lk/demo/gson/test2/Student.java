package com.tgb.lk.demo.gson.test2;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {
	private int id;
	
	@Expose
	private String name;
	
	@Expose
	@SerializedName("bir")
	private Date birthDay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Student [birthDay=" + birthDay + ", id=" + id + ", name="
				+ name + "]";
	}

}
