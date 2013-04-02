/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.xiaoxie.t.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xiaoxie.t.domain.Users;
import com.xiaoxie.t.result.User_MsgSet_PageNum;
import com.xiaoxie.t.service.UsersService;
import com.xiaoxie.t.struts.form.SignForm;

/** 
 * MyEclipse Struts
 * Creation date: 08-21-2010
 * 
 * XDoclet definition:
 * @struts.action path="/sign" name="signForm" scope="request" validate="true"
 */
public class SignAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SignForm signForm = (SignForm) form;// TODO Auto-generated method stub
		String uEmail=signForm.getUemail();
		String uName=signForm.getUname();
		String uPW=signForm.getUpw();
		String uState="login";
		String uImg="/web_alpha/picture/default.jpg";
		
		Users user=new Users(uEmail,uName,uPW,uImg,uState);
		String logicAddr="";
		if(new UsersService().addUser(user)){    //只添加用户
			user=new UsersService().checkLogin(user);//
			User_MsgSet_PageNum umspn=new User_MsgSet_PageNum(user,null,0);
			HttpSession session=request.getSession();
			session.setAttribute("umspn", umspn);
			session.setAttribute("page", 1);
			logicAddr="signsucc";
		}else{
			logicAddr="signfail";
		}
		return mapping.findForward(logicAddr);
	}
}