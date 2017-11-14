package com.uttara.dyn.eval.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import com.uttara.dyn.eval.beans.CategoryBean;

import com.uttara.dyn.eval.beans.LoginBean;
import com.uttara.dyn.eval.beans.QuestionAndSolutionWrapper;
import com.uttara.dyn.eval.beans.QuestionBean;
import com.uttara.dyn.eval.beans.QuestionDifficultness;
import com.uttara.dyn.eval.beans.SolutionBean;

import com.uttara.dyn.eval.beans.TopicBean;
import com.uttara.dyn.eval.beans.UserLoginBean;
import com.uttara.dyn.eval.persistance.AdminQuestionPerSistance;



public class AdminQuestionService {
	private AdminQuestionPerSistance adminQuestionPerSistance = new AdminQuestionPerSistance();
	protected static Logger logger = Logger.getLogger(AdminQuestionService.class);
	
	public List<QuestionBean> getQuestionCode() {
		List al=null;
		al=adminQuestionPerSistance.getQuestionCode();
		return al;
	}
	
	public List getQuestionCode1(QuestionBean questionBean) {
		List al=null;
		al=adminQuestionPerSistance.getQuestionCode1(questionBean);
		return al;
	}
	
	
	
	
	public QuestionBean getAllFieldsOfSelectedQuestion(QuestionBean questionBean ) {
		QuestionBean bean=null;
		bean=adminQuestionPerSistance.getSelectedQuestionCodeFields(questionBean);
			return bean;
	}
	
	
	
	
		public UserLoginBean loginCheck(LoginBean loginBean) {
			UserLoginBean bean = null;
			
			EncryptDecryptService encryptDecryptService = new EncryptDecryptService(loginBean.getPwd());
			loginBean.setPwd(encryptDecryptService.encrypt(loginBean.getPwd()));
		
			bean=adminQuestionPerSistance.loginCheck(loginBean);
			
			if (bean != null) 
			{
				if ((bean.getLoginName().equalsIgnoreCase(loginBean
						.getLoginName()))
						&& (bean.getPassword().equalsIgnoreCase(loginBean.getPwd()))) 
				{
					bean.setPassword("");
					return bean;
				} else
				{
					return null;
				}
			} else
			{
				return null;
			}
			
		}
	

		public int update(QuestionBean questionBean) {
			
			
			System.out.println("inside update  AdminQuestionService 777777777777");
			if(questionBean.getInputFile() != null)
			{
				File infile = questionBean.getInputFile();
				try
				{
					InputStream inputStream = new FileInputStream(infile);
					byte[] fileByte = new byte[(int) infile.length()];
					inputStream.read(fileByte);
					System.out.println(fileByte);
					questionBean.setInputFileBlobObj(fileByte);
				
				} 
				catch (Exception e)
				{
					
					e.printStackTrace();
				}
				
			}
			if(questionBean.getOutputFile() != null)
			{
				File outfile = questionBean.getOutputFile();
				try
				{
					InputStream inputStream1 = new FileInputStream(outfile);
					byte[] fileByte = new byte[(int) outfile.length()];
					inputStream1.read(fileByte);
					questionBean.setOutputFileBlobObj(fileByte);
				
				} 
				catch (Exception e)
				{				
					e.printStackTrace();
				}
			}	
			java.text.DateFormat dt = new java.text.SimpleDateFormat("dd-MMM-yyyy");
			java.util.Date date = new java.util.Date();
			questionBean.setModifiddate(dt.format(date));
			
			Integer levelScore = getlevelScore(questionBean);
			System.out.println("inside 777777        "+levelScore);
			System.out.println("inside 777777 cat sl "+questionBean.getCatSlno());
			System.out.println("inside 777777 topic  sl "+questionBean.getTopicslno());
			questionBean.setPoints(levelScore);
			int i = adminQuestionPerSistance.update(questionBean);
			return i;
		}
	
		public boolean uploadAdminAnswer(QuestionBean questionBean) {
			
			  boolean flag=false;
				
				if(questionBean.getInputFile() != null)
				{
					File infile = questionBean.getInputFile();
					System.out.println("inside insertFile(): " + questionBean.getInputFileFileName());
					System.out.println(" Question bean level sl no  "+questionBean.getDiffSlno());
					System.out.println("solution file  name "+questionBean.getSolutionFileFileName());
					try
					{
						InputStream inputStream = new FileInputStream(infile);
						byte[] fileByte = new byte[(int) infile.length()];
						inputStream.read(fileByte);
						questionBean.setInputFileBlobObj(fileByte);
					
					} 
					catch (Exception e)
					{
						
						e.printStackTrace();
					}
					
				}
				if(questionBean.getOutputFile() != null)
				{
					File outfile = questionBean.getOutputFile();
					try
					{
						InputStream inputStream1 = new FileInputStream(outfile);
						byte[] fileByte = new byte[(int) outfile.length()];
						inputStream1.read(fileByte);
						questionBean.setOutputFileBlobObj(fileByte);
					
					} 
					catch (Exception e)
					{				
						e.printStackTrace();
					}
				}	
				
				if (questionBean.getSolutionFile() !=null)
				{
					File solutionFile=questionBean.getSolutionFile();
					
					try
					{
					
						InputStream in=new FileInputStream(solutionFile);
						byte[] fileByte=new byte[(int)solutionFile.length()];
						in.read(fileByte);
						questionBean.setSolutionFileBlobObj(fileByte);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					
				}
				java.text.DateFormat dt = new java.text.SimpleDateFormat("dd-MMM-yyyy");
				java.util.Date date = new java.util.Date();
				questionBean.setCreateDate(dt.format(date));
				System.out.println("level  "+ questionBean.getLevelName());
				Integer levelScore = getlevelScore(questionBean);
				questionBean.setPoints(levelScore);
				System.out.println("topicsl   "+ questionBean.getTopicslno());
				System.out.println("catsl   "+ questionBean.getCatSlno());
			
				System.out.println("--------------  AdminQuestionService levelscore "+levelScore);
				questionBean.setPoints(levelScore);
				
				
				int count = adminQuestionPerSistance.fetchMaxQuestOrder(questionBean);
				questionBean.setQuest_order(count+1);
				
				flag=adminQuestionPerSistance.insertStudentAnswer(questionBean);
				return flag;
			}

		public void deleteQuestion(QuestionBean questionBean) {
			adminQuestionPerSistance.deleteQuestion(questionBean);
			
		}
          
		public List<TopicBean> fetchTopicName() {
			List<TopicBean> topicBean = null;
			topicBean=adminQuestionPerSistance.fetchTopicName();
			return topicBean;
		}

		public List<CategoryBean> fetchCatogeryName() {
		List<CategoryBean> list = null;
		list = adminQuestionPerSistance.fetchCatogeryName();
			return list;
		}

		public List fetchTopicName1() {
			List<CategoryBean> list = null;
			list = adminQuestionPerSistance.fetchCatogeryName1();
				return list;
		}

		public List<QuestionDifficultness> fetchQuestionLevel() {
			// TODO Auto-generated method stub
			List<QuestionDifficultness> list=null;
			list=adminQuestionPerSistance.fetchDiffQuesList();
			return list;
			
		}
		

		public int getlevelScore(QuestionBean questionBean)
		{
			Integer points=null;
			QuestionDifficultness questionDifficultness=adminQuestionPerSistance.getlevelScorefromDb(questionBean);
			//points=adminQuestionPerSistance.getlevelScorefromDb(questionBean);
			System.out.println("getlevelScor in    AdminQuestionService "  +points);
			 return questionDifficultness.getLevelScore();
		}

		public boolean resetQuestOrder(
				List<QuestionAndSolutionWrapper> resetOrdertList) {
			return adminQuestionPerSistance.resetQuestOrder(resetOrdertList);
		}
		
}
