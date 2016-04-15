package com.cesar.twitter.bean;

/**
 * UserMentions entity. @author MyEclipse Persistence Tools
 */

public class UserMentions implements java.io.Serializable {

	// Fields

	private Long id;
	private String screenName;
	private String name;

	// Constructors

	/** default constructor */
	public UserMentions() {
	}

	/** minimal constructor */
	public UserMentions(Long id) {
		this.id = id;
	}

	/** full constructor */
	public UserMentions(Long id, String screenName, String name) {
		this.id = id;
		this.screenName = screenName;
		this.name = name;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}