package com.javatzxx.android.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//@Entity
//@Table(name="SYS_USER")
public class UserEntity implements Serializable{
	private String name;
	private String pass;
	private String user_id;
	private String user_role;
	
//	@Id
//	@Column(name="USER_ID")
//	@GeneratedValue(generator ="uuid")
//	@GenericGenerator(name="uuid",strategy="uuid")
//	public String getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(String user_id) {
//		this.user_id = user_id;
//	}
//	@Column(name="USER_NAME")
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	@Column(name="USER_PASS")
//	public String getPass() {
//		return pass;
//	}
//	public void setPass(String pass) {
//		this.pass = pass;
//	}
//	@Column(name="USER_ROLE")
//	public String getUser_role() {
//		return user_role;
//	}
//	public void setUser_role(String user_role) {
//		this.user_role = user_role;
//	}
//	@Override
//	public String toString() {
//		return "UserEntity [name=" + name + ", pass=" + pass + ", user_id="
//				+ user_id + "]";
//	}
	
}
