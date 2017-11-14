package com.uttara.dyn.eval.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uttara.dyn.eval.beans.AuthenticationBean;
import com.uttara.dyn.eval.beans.LoginBean;
import com.uttara.dyn.eval.beans.UserLoginBean;
import com.uttara.dyn.eval.common.Constants;
import com.uttara.dyn.eval.common.Constants.UserRole;
import com.uttara.dyn.eval.service.AdminQuestionService;
import com.uttara.dyn.eval.listener.JedisPoolInitializer;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class LoginAction extends ActionSupport implements
		ModelDriven<LoginBean> ,ServletContextAware,SessionAware
		{
		private AdminQuestionService adminQuestionService = new AdminQuestionService();
		private LoginBean loginBean = new LoginBean();
		protected static Logger logger = Logger.getLogger(LoginAction.class);
		Map session;	
		private ServletContext servletContext;
		public String execute() 
		{
			System.out.println("Inside execute.......");
			JedisPool pool = JedisPoolInitializer.getPool();
			boolean isUserCached = true;
			Jedis jedis = null;
			logger.debug("inside LoginAction execute(): " + logger);
			logger.debug("login name: " + loginBean.getLoginName());
			System.out.println(loginBean.getBatchNo());
			System.out.println(loginBean.getMobile());
			//LoginBean bean = null;
			UserLoginBean bean = null;
			
			try {
				System.out.println("Inside try...");
				jedis = pool.getResource();
				if((bean=JSON.parseObject(jedis.get(loginBean.getLoginName()),UserLoginBean.class))==null){
				 System.out.println("User credentials aren't cached");
				 bean = adminQuestionService.loginCheck(loginBean);	
				 isUserCached = false;
				}
				}
				finally {
					if(jedis!=null)
						jedis.close();
				}
			if(isUserCached){
				System.out.println("User credentials retreived from cache");
			}
			
			if(bean!=null)
			{	
				System.out.println(bean);
				loginBean.setFirstName(bean.getFirstName());
				loginBean.setBatchNo(bean.getBatchNo());
				loginBean.setMobile(bean.getMobile());
			
			
			}
			else
			{
				System.out.println("bean null");
			}
			String s=(String) servletContext.getInitParameter("TemplatefilePath");
			System.out.println("from context -path-------------------  >  "+s);
			session.put("TemplatefilePath",s);
			if (bean != null) 
			{
				AuthenticationBean authenticationBean = new AuthenticationBean();
				System.out.println("result bean:::" + bean);
				if(!isUserCached){
					System.out.println("Caching user details");
					try{
						jedis = pool.getResource();
						jedis.set(bean.getLoginName(), JSON.toJSONString(bean));
					}
					finally{
						if(jedis!=null)
							jedis.close();
					}
				}
				if (bean.getRole().equalsIgnoreCase("admin")) 
				{
					Map session = ActionContext.getContext().getSession();
					session.put("loginValues",loginBean);
					session.put("role", "admin");
					session.put("name", loginBean.getLoginName());
					session.put("firstName", bean.getFirstName());
					session.put("slno", bean.getSlno());
					
				
					authenticationBean.setLoginName( loginBean.getLoginName() );
					authenticationBean.setUserRole( UserRole.admin);				
					session.put(Constants.SessionAttributes.authBean.name(), authenticationBean);				
					return "admin";
				} 
				else if (bean.getRole().equalsIgnoreCase("student") && bean.getStatus().equals("active"))
				{
					Map session = ActionContext.getContext().getSession();
					session.put("loginValues", loginBean);
					session.put("role", "student");
					session.put("name", loginBean.getLoginName());
					session.put("slno", bean.getSlno());
					session.put("firstName", bean.getFirstName());
					logger.debug(":::::::::::::::::::::::::::::::::::::::"+bean.getSlno());
					logger.debug(":::::::::::::::::::::::::::::::::::::::"+loginBean.getLoginName());
			
					authenticationBean.setLoginName( loginBean.getLoginName() );
					authenticationBean.setUserRole( UserRole.student);
					session.put(Constants.SessionAttributes.authBean.name(), authenticationBean);
					return "student";
				}
				else 
				{
					logger.debug("return to login.jsp");
					addActionError(getText("invalidUser.msg"));
					return "input";
				}
			} 
			else 
			{
				logger.debug("result is null");
				addActionError("invalid user_id or name!");
				return "input";
			}
		}

	public LoginBean getModel() {

		return loginBean;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}

	public void setServletContext(ServletContext arg0) {
		
		this.servletContext=arg0;
	}

}
