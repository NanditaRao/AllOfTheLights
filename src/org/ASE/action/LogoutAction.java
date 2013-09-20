package org.ASE.action;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LogoutAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute()
			throws Exception {
	
		try{
			
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("loginUser", "");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
		// TODO: handle exception
		}

}

