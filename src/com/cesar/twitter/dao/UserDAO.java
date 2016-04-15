package com.cesar.twitter.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cesar.twitter.bean.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cesar.twitter.bean.User
 * @author MyEclipse Persistence Tools
 */
public class UserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String PROFILE_SIDEBAR_FILL_COLOR = "profileSidebarFillColor";
	public static final String PROFILE_TEXT_COLOR = "profileTextColor";
	public static final String FOLLOWERS_COUNT = "followersCount";
	public static final String LOCATION = "location";
	public static final String PROFILE_BACKGROUND_COLOR = "profileBackgroundColor";
	public static final String LISTED_COUNT = "listedCount";
	public static final String STATUSES_COUNT = "statusesCount";
	public static final String DESCRIPTION = "description";
	public static final String FRIENDS_COUNT = "friendsCount";
	public static final String PROFILE_LINK_COLOR = "profileLinkColor";
	public static final String PROFILE_IMAGE_URL = "profileImageUrl";
	public static final String GEO_ENABLED = "geoEnabled";
	public static final String PROFILE_BANNER_URL = "profileBannerUrl";
	public static final String PROFILE_BACKGROUND_IMAGE_URL = "profileBackgroundImageUrl";
	public static final String SCREEN_NAME = "screenName";
	public static final String LANG = "lang";
	public static final String PROFILE_BACKGROUND_TILE = "profileBackgroundTile";
	public static final String FAVOURITES_COUNT = "favouritesCount";
	public static final String NAME = "name";
	public static final String URL = "url";
	public static final String CREATED_AT = "createdAt";
	public static final String PROTECTED_ = "protected_";
	public static final String DEFAULT_PROFILE = "defaultProfile";

	protected void initDao() {
		// do nothing
	}

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Long id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get(
					"com.cesar.twitter.bean.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProfileSidebarFillColor(Object profileSidebarFillColor) {
		return findByProperty(PROFILE_SIDEBAR_FILL_COLOR,
				profileSidebarFillColor);
	}

	public List findByProfileTextColor(Object profileTextColor) {
		return findByProperty(PROFILE_TEXT_COLOR, profileTextColor);
	}

	public List findByFollowersCount(Object followersCount) {
		return findByProperty(FOLLOWERS_COUNT, followersCount);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByProfileBackgroundColor(Object profileBackgroundColor) {
		return findByProperty(PROFILE_BACKGROUND_COLOR, profileBackgroundColor);
	}

	public List findByListedCount(Object listedCount) {
		return findByProperty(LISTED_COUNT, listedCount);
	}

	public List findByStatusesCount(Object statusesCount) {
		return findByProperty(STATUSES_COUNT, statusesCount);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByFriendsCount(Object friendsCount) {
		return findByProperty(FRIENDS_COUNT, friendsCount);
	}

	public List findByProfileLinkColor(Object profileLinkColor) {
		return findByProperty(PROFILE_LINK_COLOR, profileLinkColor);
	}

	public List findByProfileImageUrl(Object profileImageUrl) {
		return findByProperty(PROFILE_IMAGE_URL, profileImageUrl);
	}

	public List findByGeoEnabled(Object geoEnabled) {
		return findByProperty(GEO_ENABLED, geoEnabled);
	}

	public List findByProfileBannerUrl(Object profileBannerUrl) {
		return findByProperty(PROFILE_BANNER_URL, profileBannerUrl);
	}

	public List findByProfileBackgroundImageUrl(Object profileBackgroundImageUrl) {
		return findByProperty(PROFILE_BACKGROUND_IMAGE_URL,
				profileBackgroundImageUrl);
	}

	public List findByScreenName(Object screenName) {
		return findByProperty(SCREEN_NAME, screenName);
	}

	public List findByLang(Object lang) {
		return findByProperty(LANG, lang);
	}

	public List findByProfileBackgroundTile(Object profileBackgroundTile) {
		return findByProperty(PROFILE_BACKGROUND_TILE, profileBackgroundTile);
	}

	public List findByFavouritesCount(Object favouritesCount) {
		return findByProperty(FAVOURITES_COUNT, favouritesCount);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByCreatedAt(Object createdAt) {
		return findByProperty(CREATED_AT, createdAt);
	}

	public List findByProtected_(Object protected_) {
		return findByProperty(PROTECTED_, protected_);
	}

	public List findByDefaultProfile(Object defaultProfile) {
		return findByProperty(DEFAULT_PROFILE, defaultProfile);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}
}