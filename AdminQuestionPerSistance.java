package com.uttara.dyn.eval.persistance;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.uttara.dyn.eval.beans.CategoryBean;
import com.uttara.dyn.eval.beans.CorrectResultBean;
import com.uttara.dyn.eval.beans.LoginBean;
import com.uttara.dyn.eval.beans.QuestionAndSolutionWrapper;
import com.uttara.dyn.eval.beans.QuestionBean;
import com.uttara.dyn.eval.beans.QuestionDifficultness;
import com.uttara.dyn.eval.beans.TopicBean;
import com.uttara.dyn.eval.beans.UserLoginBean;


public class AdminQuestionPerSistance {
	protected static Logger logger = Logger
			.getLogger(AdminQuestionPerSistance.class);

/*	public QuestionBean getSelectedQuestionCodeFields(QuestionBean questionBean) {
		QuestionBean list = null;
		SqlMapClient smc = null;
		QuestionDifficultness questionDifficultnessBean=null; 
		smc = SqlMap.getSqlClientInstance();
		try {
			list = (QuestionBean) smc.queryForObject(
					DaoSAdminIbatisConstants.IBATIS_selectQuestionCodeFields,
					questionBean);
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
	*/
	
	public QuestionBean getSelectedQuestionCodeFields(QuestionBean questionBean) {
		QuestionBean list = null;
		SqlMapClient smc = null;
		QuestionDifficultness questionDifficultnessBean=null; 
		smc = SqlMap.getSqlClientInstance();
		logger.debug("8888888888888888888888888888  "+questionBean.getSlno());
		try {
			list = (QuestionBean) smc.queryForObject(
					DaoSAdminIbatisConstants.IBATIS_selectQuestionCodeFields,
					questionBean);
			
			
			logger.debug("inside getSelectedQuestionCodeFieldsAdminQuestionPerSistance ");
			logger.debug("list.getCatogeryName()"+list.getCatogeryName());
			logger.debug(list.getTopicName());
			logger.debug("list input test "+list.getInputtext());
			logger.debug("8888888888888888888888888888");
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
	

	public List getQuestionCode() {
		List<QuestionBean> list = null;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		try {
			list = smc.queryForList(DaoSAdminIbatisConstants.IBATIS_selectQuestionCode);
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	public UserLoginBean loginCheck(LoginBean loginBean) {
		logger.debug("inside Login Check  ");
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		//LoginBean bean = null;
		UserLoginBean bean = null;
		try {
			bean = (UserLoginBean) smc.queryForObject(
					DaoSAdminIbatisConstants.IBATIS_login, loginBean);
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int update(QuestionBean questionBean) {
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		int i = 0;
		try {
			i = smc.update(
					DaoSAdminIbatisConstants.IBATIS_updateAdminQuestionFields,
					questionBean);
		} catch (SQLException e) {
			i = 0;

			e.printStackTrace();
		}
		return i;
	}

	public boolean insertStudentAnswer(QuestionBean questionBean) {

		boolean flag = true;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		try {
			smc.insert(
					DaoSAdminIbatisConstants.IBATIS_uploadAdminQuestionAndAnswer,
					questionBean);
		} catch (SQLException e) {
			flag = false;

			e.printStackTrace();
		}
		return flag;
	}

	public void deleteQuestion(QuestionBean questionBean) {
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		try {
			smc.delete(
					DaoSAdminIbatisConstants.IBATIS_deleteAdminQuestionAndAnswer,
					questionBean);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<TopicBean> fetchTopicName() {
		List<TopicBean> topicBean = null;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		try {
			topicBean = (List<TopicBean>) smc
					.queryForList(DaoSAdminIbatisConstants.IBATIS_selectTopicName);
			return topicBean;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	public List<CategoryBean> fetchCatogeryName() {
		List<CategoryBean> categoryBean = null;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		try {
			categoryBean = (List<CategoryBean>) smc
					.queryForList(DaoSAdminIbatisConstants.IBATIS_selectCatogeryName);
			return categoryBean;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public List<CategoryBean> fetchCatogeryName1() {
		List<CategoryBean> categoryBean = null;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		try {
			categoryBean = (List<CategoryBean>) smc
					.queryForList(DaoSAdminIbatisConstants.IBATIS_selectTopic);
			return categoryBean;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public List getQuestionCode1(QuestionBean questionBean) {
		List<QuestionBean> list = null;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();

		try {
			list = smc.queryForList(
					DaoSAdminIbatisConstants.IBATIS_selectQuestionCode,
					questionBean);
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public List<QuestionDifficultness> fetchDiffQuesList() {
		List <QuestionDifficultness> list=null;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();

		try {
			list = smc.queryForList(
					DaoSAdminIbatisConstants.IBATIS_selectQuestionLevel);
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
		
	}

	public QuestionDifficultness getlevelScorefromDb(QuestionBean questionBean) {
		logger.debug("inside getlevelScorefromDb   "+questionBean.getDiffSlno());
		Integer x=null;
		QuestionDifficultness questionDifficultness=null;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();

		try {
			questionDifficultness=(QuestionDifficultness)smc.queryForObject(DaoSAdminIbatisConstants.IBATIS_selectScore,questionBean);
			logger.debug("inside adques service;;;;;;;;, "+questionDifficultness.getLevelName());
			logger.debug("inside adques service;;;;;;;;, "+questionDifficultness.getLevelScore());
			return questionDifficultness;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}


	public boolean resetQuestOrder(
			List<QuestionAndSolutionWrapper> resetOrdertList) {
		boolean flag = false;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();
		
		try {
			smc.startTransaction();
			smc.startBatch();
			
			for(QuestionAndSolutionWrapper bean: resetOrdertList)
				smc.update(DaoSAdminIbatisConstants.IBATIS_resetQuestOrder, bean);
			
			int count = smc.executeBatch();
			logger.debug("Quest order updated count: " + count);
			smc.commitTransaction();
			flag = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally{
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		
		return flag;
	}


	public int fetchMaxQuestOrder(QuestionBean questionBean) {
		logger.debug("inside fetchMaxQuestOrder AdminQuestionPerSistance ");
		int count = 0;
		SqlMapClient smc = null;
		smc = SqlMap.getSqlClientInstance();

		try {
			count = (Integer) smc.queryForObject(DaoSAdminIbatisConstants.IBATIS_maxQuestOrder,questionBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	
}
