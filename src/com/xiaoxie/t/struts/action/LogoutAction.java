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

/** 
 * MyEclipse Struts
 * Creation date: 09-29-2010
 * 
 * XDoclet definition:
 * @struts.action
 */
public class LogoutAction extends Action {
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
		HttpSession session=request.getSession(false);
		User_MsgSet_PageNum umspn=(User_MsgSet_PageNum)session.getAttribute("umspn");
		Users user=umspn.getUser();
		user.setUstate("logout");
		if(new UsersService().updateUsers(user)){
			session.invalidate();
			return mapping.findForward("logoutsucc");
		}
		return null;
	}
}