package com.cesar.twitter.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cesar.twitter.bean.Statu;

/**
 * A data access object (DAO) providing persistence and search support for Statu
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cesar.twitter.bean.Statu
 * @author MyEclipse Persistence Tools
 */
public class StatuDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(StatuDAO.class);
	// property constants
	public static final String TEXT = "text";
	public static final String LANG = "lang";
	public static final String FAVORITED = "favorited";
	public static final String RETWEETED_STATUS_ID = "retweetedStatusId";
	public static final String TRUNCATED = "truncated";
	public static final String MEDIA_ID = "mediaId";
	public static final String CREATED_AT = "createdAt";
	public static final String HASHTAGS = "hashtags";
	public static final String RETWEETED = "retweeted";
	public static final String USER_MENTIONS_ID = "userMentionsId";
	public static final String SOURCE = "source";
	public static final String USER_ID = "userId";
	public static final String URLS = "urls";
	public static final String RETWEET_COUNT = "retweetCount";

	protected void initDao() {
		// do nothing
	}

	public void save(Statu transientInstance) {
		log.debug("saving Statu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Statu persistentInstance) {
		log.debug("deleting Statu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Statu findById(java.lang.Long id) {
		log.debug("getting Statu instance with id: " + id);
		try {
			Statu instance = (Statu) getHibernateTemplate().get(
					"com.cesar.twitter.bean.Statu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Statu instance) {
		log.debug("finding Statu instance by example");
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
		log.debug("finding Statu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Statu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List findByLang(Object lang) {
		return findByProperty(LANG, lang);
	}

	public List findByFavorited(Object favorited) {
		return findByProperty(FAVORITED, favorited);
	}

	public List findByRetweetedStatusId(Object retweetedStatusId) {
		return findByProperty(RETWEETED_STATUS_ID, retweetedStatusId);
	}

	public List findByTruncated(Object truncated) {
		return findByProperty(TRUNCATED, truncated);
	}

	public List findByMediaId(Object mediaId) {
		return findByProperty(MEDIA_ID, mediaId);
	}

	public List findByCreatedAt(Object createdAt) {
		return findByProperty(CREATED_AT, createdAt);
	}

	public List findByHashtags(Object hashtags) {
		return findByProperty(HASHTAGS, hashtags);
	}

	public List findByRetweeted(Object retweeted) {
		return findByProperty(RETWEETED, retweeted);
	}

	public List findByUserMentionsId(Object userMentionsId) {
		return findByProperty(USER_MENTIONS_ID, userMentionsId);
	}

	public List findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByUrls(Object urls) {
		return findByProperty(URLS, urls);
	}

	public List findByRetweetCount(Object retweetCount) {
		return findByProperty(RETWEET_COUNT, retweetCount);
	}

	public List findAll() {
		log.debug("finding all Statu instances");
		try {
			String queryString = "from Statu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Statu merge(Statu detachedInstance) {
		log.debug("merging Statu instance");
		try {
			Statu result = (Statu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Statu instance) {
		log.debug("attaching dirty Statu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Statu instance) {
		log.debug("attaching clean Statu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StatuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StatuDAO) ctx.getBean("StatuDAO");
	}
}