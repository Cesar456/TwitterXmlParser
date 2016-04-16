package com.cesar.twitter.service;

import java.io.File;
import java.util.List;

import com.cesar.twitter.bean.Media;
import com.cesar.twitter.bean.RetweetedStatus;
import com.cesar.twitter.bean.Statu;
import com.cesar.twitter.bean.User;
import com.cesar.twitter.bean.UserMentions;
import com.cesar.twitter.dao.MediaDAO;
import com.cesar.twitter.dao.RetweetedStatusDAO;
import com.cesar.twitter.dao.StatuDAO;
import com.cesar.twitter.dao.UserDAO;
import com.cesar.twitter.dao.UserMentionsDAO;
import com.cesar.twitter.util.CommonUtil;
import com.cesar.twitter.util.FileUtil;
import com.cesar.twitter.util.XmlUtil;

/**
 * 所有主要的操作逻辑
 * 
 * @author Cesar
 * 
 */
public class ParseMainService {

	private StatuDAO statuDAO;
	private RetweetedStatusDAO retweetedStatusDAO;
	private MediaDAO mediaDAO;
	private UserDAO userDAO;
	private UserMentionsDAO userMentionsDAO;

	public void parseXml() {
		String[] foderPath = FileUtil.getRootFolderList();
		for (String folder : foderPath) {
			System.out.println(folder + " 开始执行...");
			File[] files = FileUtil.getFileList(folder);
			for (File file : files) {
				List<Statu> status = XmlUtil.twitter_xml_parser(file);
				for (Statu statu : status) {
					try {
						saveStatu(statu);
					} catch (Exception e) {
						CommonUtil.log(file.getAbsolutePath()+"  id="+statu.getId()+"  err");
						CommonUtil.log(e.getMessage());
					}
				}
				System.out.println("...");
			}
			System.out.println(folder + " 执行完毕");
		}
		System.out.println("全部完毕");
	}

	private void saveStatu(Statu statu) {

		if (statuDAO.findById(statu.getId()) != null) {
			return;
		}

		if (statu.getMedia() != null) {
			Media medias = mediaDAO.findById(statu.getMedia().getId());
			if (medias == null) {
				mediaDAO.save(statu.getMedia());
			}
			statu.setMediaId(statu.getMedia().getId());
		}
		if (statu.getRetweetedStatus() != null) {
			saveRetStatus(statu.getRetweetedStatus());
			statu.setRetweetedStatusId(statu.getRetweetedStatus().getId());
		}
		if (statu.getUser() != null) {
			User user = userDAO.findById(statu.getUser().getId());
			if (user == null) {
				userDAO.save(statu.getUser());
			}
			statu.setUserId(statu.getUser().getId());
		}
		if (statu.getUserMentions() != null) {
			UserMentions userMentions = userMentionsDAO.findById(statu
					.getUserMentions().getId());
			if (userMentions == null) {
				userMentionsDAO.save(statu.getUserMentions());
			}
			statu.setUserMentionsId(statu.getUserMentions().getId());
		}
		statuDAO.save(statu);
	}

	private void saveRetStatus(RetweetedStatus retweetedStatus) {
		
		if(retweetedStatusDAO.findById(retweetedStatus.getId())!=null){
			return;
		}
		
		if (retweetedStatus.getMedia() != null) {
			Media media = mediaDAO.findById(retweetedStatus.getMedia().getId());
			if (media == null) {
				mediaDAO.save(retweetedStatus.getMedia());
			}
			retweetedStatus.setMediaId(retweetedStatus.getMedia().getId());
		}
		if (retweetedStatus.getUser() != null) {
			User user = userDAO.findById(retweetedStatus.getUser().getId());
			if (user == null) {
				userDAO.save(retweetedStatus.getUser());
			}
			retweetedStatus.setUserId(retweetedStatus.getUser().getId());
		}
		retweetedStatusDAO.save(retweetedStatus);
	}

	public StatuDAO getStatuDAO() {
		return statuDAO;
	}

	public void setStatuDAO(StatuDAO statuDAO) {
		this.statuDAO = statuDAO;
	}

	public RetweetedStatusDAO getRetweetedStatusDAO() {
		return retweetedStatusDAO;
	}

	public void setRetweetedStatusDAO(RetweetedStatusDAO retweetedStatusDAO) {
		this.retweetedStatusDAO = retweetedStatusDAO;
	}

	public MediaDAO getMediaDAO() {
		return mediaDAO;
	}

	public void setMediaDAO(MediaDAO mediaDAO) {
		this.mediaDAO = mediaDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserMentionsDAO getUserMentionsDAO() {
		return userMentionsDAO;
	}

	public void setUserMentionsDAO(UserMentionsDAO userMentionsDAO) {
		this.userMentionsDAO = userMentionsDAO;
	}
}
