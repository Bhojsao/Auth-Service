package com.bhoj.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bhoj.springboot.dto.LoginDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Login Entity
 * 
 * @author Bhoj Sao
 *
 */
@Table(name = "LOGIN")
@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ID_SEQUENCE", sequenceName = "LOGIN_ID_SEQ")
	@Column(name = "LOGIN_ID")
	@JsonProperty
	private Integer loginId;

	@Column(name = "USER_NAME")
	@JsonProperty
	private String userName;

	@Column(name = "PASSWORD")
	@JsonProperty
	private String password;

	public Login() {
	}

	/**
	 * Customized Constructor
	 * 
	 * @param loginDTO
	 */
	public Login(LoginDTO loginDTO) {
		this.userName = loginDTO.getUserName();
		this.password = loginDTO.getPassword();
	}
	

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
