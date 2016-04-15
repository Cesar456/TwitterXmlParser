package com.cesar.twitter.bean;

/**
 * Statu entity. @author MyEclipse Persistence Tools
 */

public class Statu implements java.io.Serializable {

	// Fields

	private Long id;
	private String text;
	private String lang;
	private String favorited;
	
	private RetweetedStatus retweetedStatus;
	private Long retweetedStatusId;
	
	private String truncated;
	
	private Media media;
	private Long mediaId;

	private String createdAt;
	private String hashtags;
	private String retweeted;
	
	private UserMentions userMentions;
	private Long userMentionsId;
	
	private String source;
	
	private User user;
	private Long userId;
	
	private String urls;
	private Integer retweetCount;

	// Constructors

	/** default constructor */
	public Statu() {
	}

	/** minimal constructor */
	public Statu(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Statu(Long id, String text, String lang, String favorited,
			Long retweetedStatusId, String truncated, Long mediaId,
			String createdAt, String hashtags, String retweeted,
			Long userMentionsId, String source, Long userId, String urls,
			Integer retweetCount) {
		this.id = id;
		this.text = text;
		this.lang = lang;
		this.favorited = favorited;
		this.retweetedStatusId = retweetedStatusId;
		this.truncated = truncated;
		this.mediaId = mediaId;
		this.createdAt = createdAt;
		this.hashtags = hashtags;
		this.retweeted = retweeted;
		this.userMentionsId = userMentionsId;
		this.source = source;
		this.userId = userId;
		this.urls = urls;
		this.retweetCount = retweetCount;
	}
	
	
	

	// Property accessors

	public RetweetedStatus getRetweetedStatus() {
		return retweetedStatus;
	}

	public void setRetweetedStatus(RetweetedStatus retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public UserMentions getUserMentions() {
		return userMentions;
	}

	public void setUserMentions(UserMentions userMentions) {
		this.userMentions = userMentions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getFavorited() {
		return this.favorited;
	}

	public void setFavorited(String favorited) {
		this.favorited = favorited;
	}

	public Long getRetweetedStatusId() {
		return this.retweetedStatusId;
	}

	public void setRetweetedStatusId(Long retweetedStatusId) {
		this.retweetedStatusId = retweetedStatusId;
	}

	public String getTruncated() {
		return this.truncated;
	}

	public void setTruncated(String truncated) {
		this.truncated = truncated;
	}

	public Long getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getHashtags() {
		return this.hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public String getRetweeted() {
		return this.retweeted;
	}

	public void setRetweeted(String retweeted) {
		this.retweeted = retweeted;
	}

	public Long getUserMentionsId() {
		return this.userMentionsId;
	}

	public void setUserMentionsId(Long userMentionsId) {
		this.userMentionsId = userMentionsId;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUrls() {
		return this.urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public Integer getRetweetCount() {
		return this.retweetCount;
	}

	public void setRetweetCount(Integer retweetCount) {
		this.retweetCount = retweetCount;
	}

}