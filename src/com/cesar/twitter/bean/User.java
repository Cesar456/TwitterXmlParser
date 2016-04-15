package com.cesar.twitter.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String profileSidebarFillColor;
	private String profileTextColor;
	private Integer followersCount;
	private String location;
	private String profileBackgroundColor;
	private Integer listedCount;
	private Integer statusesCount;
	private String description;
	private Integer friendsCount;
	private String profileLinkColor;
	private String profileImageUrl;
	private String geoEnabled;
	private String profileBannerUrl;
	private String profileBackgroundImageUrl;
	private String screenName;
	private String lang;
	private String profileBackgroundTile;
	private Integer favouritesCount;
	private String name;
	private String url;
	private String createdAt;
	private String protected_;
	private String defaultProfile;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Long id) {
		this.id = id;
	}

	/** full constructor */
	public User(Long id, String profileSidebarFillColor,
			String profileTextColor, Integer followersCount, String location,
			String profileBackgroundColor, Integer listedCount,
			Integer statusesCount, String description, Integer friendsCount,
			String profileLinkColor, String profileImageUrl, String geoEnabled,
			String profileBannerUrl, String profileBackgroundImageUrl,
			String screenName, String lang, String profileBackgroundTile,
			Integer favouritesCount, String name, String url, String createdAt,
			String protected_, String defaultProfile) {
		this.id = id;
		this.profileSidebarFillColor = profileSidebarFillColor;
		this.profileTextColor = profileTextColor;
		this.followersCount = followersCount;
		this.location = location;
		this.profileBackgroundColor = profileBackgroundColor;
		this.listedCount = listedCount;
		this.statusesCount = statusesCount;
		this.description = description;
		this.friendsCount = friendsCount;
		this.profileLinkColor = profileLinkColor;
		this.profileImageUrl = profileImageUrl;
		this.geoEnabled = geoEnabled;
		this.profileBannerUrl = profileBannerUrl;
		this.profileBackgroundImageUrl = profileBackgroundImageUrl;
		this.screenName = screenName;
		this.lang = lang;
		this.profileBackgroundTile = profileBackgroundTile;
		this.favouritesCount = favouritesCount;
		this.name = name;
		this.url = url;
		this.createdAt = createdAt;
		this.protected_ = protected_;
		this.defaultProfile = defaultProfile;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileSidebarFillColor() {
		return this.profileSidebarFillColor;
	}

	public void setProfileSidebarFillColor(String profileSidebarFillColor) {
		this.profileSidebarFillColor = profileSidebarFillColor;
	}

	public String getProfileTextColor() {
		return this.profileTextColor;
	}

	public void setProfileTextColor(String profileTextColor) {
		this.profileTextColor = profileTextColor;
	}

	public Integer getFollowersCount() {
		return this.followersCount;
	}

	public void setFollowersCount(Integer followersCount) {
		this.followersCount = followersCount;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfileBackgroundColor() {
		return this.profileBackgroundColor;
	}

	public void setProfileBackgroundColor(String profileBackgroundColor) {
		this.profileBackgroundColor = profileBackgroundColor;
	}

	public Integer getListedCount() {
		return this.listedCount;
	}

	public void setListedCount(Integer listedCount) {
		this.listedCount = listedCount;
	}

	public Integer getStatusesCount() {
		return this.statusesCount;
	}

	public void setStatusesCount(Integer statusesCount) {
		this.statusesCount = statusesCount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFriendsCount() {
		return this.friendsCount;
	}

	public void setFriendsCount(Integer friendsCount) {
		this.friendsCount = friendsCount;
	}

	public String getProfileLinkColor() {
		return this.profileLinkColor;
	}

	public void setProfileLinkColor(String profileLinkColor) {
		this.profileLinkColor = profileLinkColor;
	}

	public String getProfileImageUrl() {
		return this.profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getGeoEnabled() {
		return this.geoEnabled;
	}

	public void setGeoEnabled(String geoEnabled) {
		this.geoEnabled = geoEnabled;
	}

	public String getProfileBannerUrl() {
		return this.profileBannerUrl;
	}

	public void setProfileBannerUrl(String profileBannerUrl) {
		this.profileBannerUrl = profileBannerUrl;
	}

	public String getProfileBackgroundImageUrl() {
		return this.profileBackgroundImageUrl;
	}

	public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
		this.profileBackgroundImageUrl = profileBackgroundImageUrl;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getProfileBackgroundTile() {
		return this.profileBackgroundTile;
	}

	public void setProfileBackgroundTile(String profileBackgroundTile) {
		this.profileBackgroundTile = profileBackgroundTile;
	}

	public Integer getFavouritesCount() {
		return this.favouritesCount;
	}

	public void setFavouritesCount(Integer favouritesCount) {
		this.favouritesCount = favouritesCount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getProtected_() {
		return this.protected_;
	}

	public void setProtected_(String protected_) {
		this.protected_ = protected_;
	}

	public String getDefaultProfile() {
		return this.defaultProfile;
	}

	public void setDefaultProfile(String defaultProfile) {
		this.defaultProfile = defaultProfile;
	}

}