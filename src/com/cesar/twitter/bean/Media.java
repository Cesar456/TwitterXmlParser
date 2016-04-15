package com.cesar.twitter.bean;

/**
 * Media entity. @author MyEclipse Persistence Tools
 */

public class Media implements java.io.Serializable {

	// Fields

	private Long id;
	private Long sourceUserId;
	private String sourceStatusIdStr;
	private String expandedUrl;
	private String displayUrl;
	private Long sourceStatusId;
	private String mediaUrlHttps;
	private String sourceUserIdStr;
	private String url;
	private String idStr;
	private Integer indices;
	private Integer indices2;
	private String type;
	private String mediaUrl;

	// Constructors

	/** default constructor */
	public Media() {
	}

	/** minimal constructor */
	public Media(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Media(Long id, Long sourceUserId, String sourceStatusIdStr,
			String expandedUrl, String displayUrl, Long sourceStatusId,
			String mediaUrlHttps, String sourceUserIdStr, String url,
			String idStr, Integer indices, Integer indices2, String type,
			String mediaUrl) {
		this.id = id;
		this.sourceUserId = sourceUserId;
		this.sourceStatusIdStr = sourceStatusIdStr;
		this.expandedUrl = expandedUrl;
		this.displayUrl = displayUrl;
		this.sourceStatusId = sourceStatusId;
		this.mediaUrlHttps = mediaUrlHttps;
		this.sourceUserIdStr = sourceUserIdStr;
		this.url = url;
		this.idStr = idStr;
		this.indices = indices;
		this.indices2 = indices2;
		this.type = type;
		this.mediaUrl = mediaUrl;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSourceUserId() {
		return this.sourceUserId;
	}

	public void setSourceUserId(Long sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public String getSourceStatusIdStr() {
		return this.sourceStatusIdStr;
	}

	public void setSourceStatusIdStr(String sourceStatusIdStr) {
		this.sourceStatusIdStr = sourceStatusIdStr;
	}

	public String getExpandedUrl() {
		return this.expandedUrl;
	}

	public void setExpandedUrl(String expandedUrl) {
		this.expandedUrl = expandedUrl;
	}

	public String getDisplayUrl() {
		return this.displayUrl;
	}

	public void setDisplayUrl(String displayUrl) {
		this.displayUrl = displayUrl;
	}

	public Long getSourceStatusId() {
		return this.sourceStatusId;
	}

	public void setSourceStatusId(Long sourceStatusId) {
		this.sourceStatusId = sourceStatusId;
	}

	public String getMediaUrlHttps() {
		return this.mediaUrlHttps;
	}

	public void setMediaUrlHttps(String mediaUrlHttps) {
		this.mediaUrlHttps = mediaUrlHttps;
	}

	public String getSourceUserIdStr() {
		return this.sourceUserIdStr;
	}

	public void setSourceUserIdStr(String sourceUserIdStr) {
		this.sourceUserIdStr = sourceUserIdStr;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdStr() {
		return this.idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public Integer getIndices() {
		return this.indices;
	}

	public void setIndices(Integer indices) {
		this.indices = indices;
	}

	public Integer getIndices2() {
		return this.indices2;
	}

	public void setIndices2(Integer indices2) {
		this.indices2 = indices2;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaUrl() {
		return this.mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

}