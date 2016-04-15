package com.cesar.twitter.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cesar.twitter.bean.Media;

/**
 * A data access object (DAO) providing persistence and search support for Media
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cesar.twitter.bean.Media
 * @author MyEclipse Persistence Tools
 */
public class MediaDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(MediaDAO.class);
	// property constants
	public static final String SOURCE_USER_ID = "sourceUserId";
	public static final String SOURCE_STATUS_ID_STR = "sourceStatusIdStr";
	public static final String EXPANDED_URL = "expandedUrl";
	public static final String DISPLAY_URL = "displayUrl";
	public static final String SOURCE_STATUS_ID = "sourceStatusId";
	public static final String MEDIA_URL_HTTPS = "mediaUrlHttps";
	public static final String SOURCE_USER_ID_STR = "sourceUserIdStr";
	public static final String URL = "url";
	public static final String ID_STR = "idStr";
	public static final String INDICES = "indices";
	public static final String INDICES2 = "indices2";
	public static final String TYPE = "type";
	public static final String MEDIA_URL = "mediaUrl";

	protected void initDao() {
		// do nothing
	}

	public void save(Media transientInstance) {
		log.debug("saving Media instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Media persistentInstance) {
		log.debug("deleting Media instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Media findById(java.lang.Long id) {
		log.debug("getting Media instance with id: " + id);
		try {
			Media instance = (Media) getHibernateTemplate().get(
					"com.cesar.twitter.bean.Media", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Media instance) {
		log.debug("finding Media instance by example");
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
		log.debug("finding Media instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Media as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySourceUserId(Object sourceUserId) {
		return findByProperty(SOURCE_USER_ID, sourceUserId);
	}

	public List findBySourceStatusIdStr(Object sourceStatusIdStr) {
		return findByProperty(SOURCE_STATUS_ID_STR, sourceStatusIdStr);
	}

	public List findByExpandedUrl(Object expandedUrl) {
		return findByProperty(EXPANDED_URL, expandedUrl);
	}

	public List findByDisplayUrl(Object displayUrl) {
		return findByProperty(DISPLAY_URL, displayUrl);
	}

	public List findBySourceStatusId(Object sourceStatusId) {
		return findByProperty(SOURCE_STATUS_ID, sourceStatusId);
	}

	public List findByMediaUrlHttps(Object mediaUrlHttps) {
		return findByProperty(MEDIA_URL_HTTPS, mediaUrlHttps);
	}

	public List findBySourceUserIdStr(Object sourceUserIdStr) {
		return findByProperty(SOURCE_USER_ID_STR, sourceUserIdStr);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByIdStr(Object idStr) {
		return findByProperty(ID_STR, idStr);
	}

	public List findByIndices(Object indices) {
		return findByProperty(INDICES, indices);
	}

	public List findByIndices2(Object indices2) {
		return findByProperty(INDICES2, indices2);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByMediaUrl(Object mediaUrl) {
		return findByProperty(MEDIA_URL, mediaUrl);
	}

	public List findAll() {
		log.debug("finding all Media instances");
		try {
			String queryString = "from Media";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Media merge(Media detachedInstance) {
		log.debug("merging Media instance");
		try {
			Media result = (Media) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Media instance) {
		log.debug("attaching dirty Media instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Media instance) {
		log.debug("attaching clean Media instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MediaDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MediaDAO) ctx.getBean("MediaDAO");
	}
}