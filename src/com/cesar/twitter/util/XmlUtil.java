package com.cesar.twitter.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cesar.twitter.bean.Media;
import com.cesar.twitter.bean.RetweetedStatus;
import com.cesar.twitter.bean.Statu;
import com.cesar.twitter.bean.User;
import com.cesar.twitter.bean.UserMentions;

/**
 * 该类主要负责解析XML文档，返回bean
 * 
 * @author Cesar
 */

public class XmlUtil {

	private XmlUtil() {

	}

	public static List<Statu> twitter_xml_parser(File file) {

		List<Statu> statuList = new ArrayList<>();

		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(file);
			Element root_element = document.getRootElement();
			Iterator<Element> status = root_element.elementIterator();
			while (status.hasNext()) {
				Statu statu = parseStatu(status.next());
				statuList.add(statu);
			}
			return statuList;
		} catch (DocumentException e) {
			e.printStackTrace();
			CommonUtil.log(file.getAbsolutePath() + " 解析错误");
		}
		return null;
	}

	/**
	 * 解析每一条推
	 */
	private static Statu parseStatu(Element statu) {

		Statu statuEntity = new Statu();
		String text = statu.elementText("text");
		String lang = statu.elementText("lang");
		String favorited = statu.elementText("favorited");
		String truncated = statu.elementText("truncated");
		String created_at = statu.elementText("created_at");
		String hashtags = statu.elementText("hashtags");
		String retweeted = statu.elementText("retweeted");
		String source = statu.elementText("source");
		String urls = statu.elementText("urls");
		String retweet_count = statu.elementText("retweet_count");
		String id = statu.elementText("id");

		statuEntity.setText(text == null ? "" : text);
		statuEntity.setLang(lang == null ? "" : lang);
		statuEntity.setFavorited(favorited == null ? "" : favorited);
		statuEntity.setTruncated(truncated == null ? "" : truncated);
		statuEntity.setCreatedAt(created_at == null ? "" : created_at);
		statuEntity.setHashtags(hashtags == null ? "" : hashtags);
		statuEntity.setRetweeted(retweeted == null ? "" : retweeted);
		statuEntity.setSource(source == null ? "" : source);
		statuEntity.setUrls(urls == null ? "" : urls);
		statuEntity.setRetweetCount(Integer
				.parseInt(retweet_count == null ? "0" : retweet_count));
		statuEntity.setId(Long.parseLong(id == null ? "0" : id));

		Element user = statu.element("user");
		Element userMentions = statu.element("user_mentions");
		Element retweetedStatus = statu.element("retweeted_status");
		Element media = statu.element("media");

		if (user != null) {
			statuEntity.setUser(parseUser(user));
		}

		if (userMentions != null) {
			statuEntity.setUserMentions(parseUserMentions(userMentions));
		}
		if (retweetedStatus != null) {
			statuEntity
					.setRetweetedStatus(parseRetweetedStatus(retweetedStatus));
		}
		if (media != null) {
			statuEntity.setMedia(parseMedia(media));
		}
		return statuEntity;
	}

	private static Media parseMedia(Element media) {

		Media mediaEntity = new Media();

		String sourceUserId = media.elementText("source_user_id");
		String sourceStatusIdStr = media.elementText("source_status_id_str");
		String expandedUrl = media.elementText("expanded_url");
		String displayUrl = media.elementText("display_url");
		String sourceStatusId = media.elementText("source_status_id");
		String mediaUrlHttps = media.elementText("media_url_https");
		String sourceUserIdStr = media.elementText("source_user_id_str");
		String url = media.elementText("url");
		String idStr = media.elementText("id_str");
		String indices = null;
		String indices2 = null;
		List<Element> indicess = media.elements("indices");
		if (indicess != null && indicess.size() >= 1) {
			indices = indicess.get(0).getText();
		}
		if (indicess != null && indicess.size() >= 2) {
			indices2 = indicess.get(1).getText();
		}
		String type = media.elementText("type");
		String id = media.elementText("id");
		String mediaUrl = media.elementText("media_url");

		mediaEntity.setSourceUserId(Long.parseLong(sourceUserId == null ? "0"
				: sourceUserId));
		mediaEntity.setSourceStatusIdStr(sourceStatusIdStr == null ? ""
				: sourceStatusIdStr);
		mediaEntity.setExpandedUrl(expandedUrl == null ? "" : expandedUrl);
		mediaEntity.setDisplayUrl(displayUrl == null ? "" : displayUrl);
		mediaEntity.setSourceStatusId(Long
				.parseLong(sourceStatusId == null ? "0" : sourceStatusId));
		mediaEntity
				.setMediaUrlHttps(mediaUrlHttps == null ? "" : mediaUrlHttps);
		mediaEntity.setSourceUserIdStr(sourceUserIdStr == null ? ""
				: sourceUserIdStr);
		mediaEntity.setUrl(url == null ? "" : url);
		mediaEntity.setIdStr(idStr == null ? "" : idStr);
		mediaEntity.setIndices(Integer
				.parseInt(indices == null ? "0" : indices));
		mediaEntity.setIndices(Integer.parseInt(indices2 == null ? "0"
				: indices2));
		mediaEntity.setType(type == null ? "" : type);
		mediaEntity.setId(Long.parseLong(id == null ? "0" : id));
		mediaEntity.setMediaUrl(mediaUrl == null ? "" : mediaUrl);
		return mediaEntity;
	}

	private static RetweetedStatus parseRetweetedStatus(Element retweetedStatus) {

		RetweetedStatus retweetedStatusEntity = new RetweetedStatus();

		String lang = retweetedStatus.elementText("lang");
		String favorited = retweetedStatus.elementText("favorited");
		String truncated = retweetedStatus.elementText("truncated");
		String created_at = retweetedStatus.elementText("created_at");
		String hashtags = retweetedStatus.elementText("hashtags");
		String retweeted = retweetedStatus.elementText("retweeted");
		String source = retweetedStatus.elementText("source");
		String urls = retweetedStatus.elementText("urls");
		String text = retweetedStatus.elementText("text");
		String retweet_count = retweetedStatus.elementText("retweet_count");
		String id = retweetedStatus.elementText("id");
		String favorited_count = retweetedStatus.elementText("favorite_count");

		retweetedStatusEntity.setText(text == null ? "" : text);
		retweetedStatusEntity.setLang(lang == null ? "" : lang);
		retweetedStatusEntity.setFavorited(favorited == null ? "" : favorited);
		retweetedStatusEntity.setTruncated(truncated == null ? "" : truncated);
		retweetedStatusEntity
				.setCreatedAt(created_at == null ? "" : created_at);
		retweetedStatusEntity.setHashtags(hashtags == null ? "" : hashtags);
		retweetedStatusEntity.setRetweeted(retweeted == null ? "" : retweeted);
		retweetedStatusEntity.setSource(source == null ? "" : source);
		retweetedStatusEntity.setUrls(urls == null ? "" : urls);
		retweetedStatusEntity.setRetweetCount(Integer
				.parseInt(retweet_count == null ? "0" : retweet_count));
		retweetedStatusEntity.setId(Long.parseLong(id == null ? "0" : id));
		retweetedStatusEntity.setFavoritedCount(Integer
				.parseInt(favorited_count == null ? "0" : favorited_count));

		Element user = retweetedStatus.element("user");
		Element media = retweetedStatus.element("media");

		if (user != null) {
			retweetedStatusEntity.setUser(parseUser(user));
		}
		if (media != null) {
			retweetedStatusEntity.setMedia(parseMedia(media));
		}

		return retweetedStatusEntity;
	}

	private static UserMentions parseUserMentions(Element userMentions) {

		UserMentions userMentionsEntity = new UserMentions();

		String screen_name = userMentions.elementText("screen_name");
		String id = userMentions.elementText("id");
		String name = userMentions.elementText("name");

		userMentionsEntity.setId(Long.parseLong(id == null ? "0" : id));
		userMentionsEntity.setName(name == null ? "" : name);
		userMentionsEntity
				.setScreenName(screen_name == null ? "" : screen_name);

		return userMentionsEntity;
	}

	/**
	 * 解析用户信息
	 * 
	 * @param element
	 */
	private static User parseUser(Element user) {

		User userEntity = new User();

		String id = user.elementText("id");
		String profile_sidebar_fill_color = user
				.elementText("profile_sidebar_fill_color");
		String profile_text_color = user.elementText("profile_text_color");
		String followers_count = user.elementText("followers_count");
		String location = user.elementText("location");
		String profile_background_color = user
				.elementText("profile_background_color");
		String listed_count = user.elementText("listed_count");
		String statuses_count = user.elementText("statuses_count");
		String description = user.elementText("description");
		String friends_count = user.elementText("friends_count");
		String profile_link_color = user.elementText("profile_link_color");
		String profile_image_url = user.elementText("profile_image_url");
		String geo_enabled = user.elementText("geo_enabled");
		String profile_banner_url = user.elementText("profile_banner_url");
		String profile_background_image_url = user
				.elementText("profile_background_image_url");
		String screen_name = user.elementText("screen_name");
		String lang = user.elementText("lang");
		String profile_background_tile = user
				.elementText("profile_background_tile");
		String favourites_count = user.elementText("favourites_count");
		String name = user.elementText("name");
		String url = user.elementText("url");
		String created_at = user.elementText("created_at");
		String protected_ = user.elementText("protected");
		String default_profile = user.elementText("default_profile");

		userEntity.setId(Long.parseLong(id == null ? "0" : id));
		userEntity
				.setProfileSidebarFillColor(profile_sidebar_fill_color == null ? ""
						: profile_sidebar_fill_color);
		userEntity.setProfileTextColor(profile_text_color == null ? ""
				: profile_text_color);
		userEntity.setFollowersCount(Integer
				.parseInt(followers_count == null ? "0" : followers_count));
		userEntity.setLocation(location == null ? "" : location);
		userEntity
				.setProfileBackgroundColor(profile_background_color == null ? ""
						: profile_background_color);
		userEntity.setListedCount(Integer.parseInt(listed_count == null ? "0"
				: listed_count));
		userEntity.setStatusesCount(Integer
				.parseInt(statuses_count == null ? "0" : statuses_count));
		userEntity.setDescription(description == null ? "" : description);
		userEntity.setFriendsCount(Integer.parseInt(friends_count == null ? "0"
				: friends_count));
		userEntity.setProfileLinkColor(profile_link_color == null ? ""
				: profile_link_color);
		userEntity.setProfileImageUrl(profile_image_url == null ? ""
				: profile_image_url);
		userEntity.setGeoEnabled(geo_enabled == null ? "" : geo_enabled);
		userEntity.setProfileBannerUrl(profile_banner_url == null ? ""
				: profile_banner_url);
		userEntity
				.setProfileBackgroundImageUrl(profile_background_image_url == null ? ""
						: profile_background_image_url);
		userEntity.setScreenName(screen_name == null ? "" : screen_name);
		userEntity.setLang(lang == null ? "" : lang);
		userEntity
				.setProfileBackgroundTile(profile_background_tile == null ? ""
						: profile_background_tile);
		userEntity.setFavouritesCount(Integer
				.parseInt(favourites_count == null ? "0" : favourites_count));
		userEntity.setName(name == null ? "" : name);
		userEntity.setUrl(url == null ? "" : url);
		userEntity.setCreatedAt(created_at == null ? "" : created_at);
		userEntity.setProtected_(protected_ == null ? "" : protected_);
		userEntity.setDefaultProfile(default_profile == null ? ""
				: default_profile);
		return userEntity;
	}

	/**
	 * 输出某个element的所有子元素名 仅供测试使用
	 * 
	 * @param element
	 */
	private static void sysChildName(Element element) {
		Iterator iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element element1 = (Element) iterator.next();
			System.out.println("String " + element1.getName()
					+ "=userMentions.elementText(\"" + element1.getName()
					+ "\");");
		}
	}

	// public static void main(String[] args) {
	// File file = new File("C:/Users/Cesar/Desktop/xml_demo.xml");
	// twitter_xml_parser(file);
	// }
}
