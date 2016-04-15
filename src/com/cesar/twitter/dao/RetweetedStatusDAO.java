package com.cesar.twitter.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cesar.twitter.bean.RetweetedStatus;

/**
 * A data access object (DAO) providing persistence and search support for
 * RetweetedStatus entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cesar.twitter.bean.RetweetedStatus
 * @author MyEclipse Persistence Tools
 */
public class RetweetedStatusDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RetweetedStatusDAO.class);
	// property constants
	public static final String TEXT = "text";
	public static final String LANG = "lang";
	public static final String FAVORITED = "favorited";
	public static final String TRUNCATED = "truncated";
	public static final String MEDIA_ID = "mediaId";
	public static final String CREATED_AT = "createdAt";
	public static final String HASHTAGS = "hashtags";
	public static final String RETWEETED = "retweeted";
	public static final String SOURCE = "source";
	public static final String USER_ID = "userId";
	public static final String URLS = "urls";
	public static final String RETWEET_COUNT = "retweetCount";
	public static final String FAVORITED_COUNT = "favoritedCount";

	protected void initDao() {
		// do nothing
	}

	public void save(RetweetedStatus transientInstance) {
		log.debug("saving RetweetedStatus instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RetweetedStatus persistentInstance) {
		log.debug("deleting RetweetedStatus instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RetweetedStatus findById(java.lang.Long id) {
		log.debug("getting RetweetedStatus instance with id: " + id);
		try {
			RetweetedStatus instance = (RetweetedStatus) getHibernateTemplate()
					.get("com.cesar.twitter.bean.RetweetedStatus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RetweetedStatus instance) {
		log.debug("finding RetweetedStatus instance by example");
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
		log.debug("finding RetweetedStatus instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RetweetedStatus as model where model."
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

	public List findByFavoritedCount(Object favoritedCount) {
		return findByProperty(FAVORITED_COUNT, favoritedCount);
	}

	public List findAll() {
		log.debug("finding all RetweetedStatus instances");
		try {
			String queryString = "from RetweetedStatus";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RetweetedStatus merge(RetweetedStatus detachedInstance) {
		log.debug("merging RetweetedStatus instance");
		try {
			RetweetedStatus result = (RetweetedStatus) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RetweetedStatus instance) {
		log.debug("attaching dirty RetweetedStatus instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RetweetedStatus instance) {
		log.debug("attaching clean RetweetedStatus instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RetweetedStatusDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (RetweetedStatusDAO) ctx.getBean("RetweetedStatusDAO");
	}
}