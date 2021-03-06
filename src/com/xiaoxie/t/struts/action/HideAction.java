/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.xiaoxie.t.struts.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xiaoxie.t.domain.Hide;
import com.xiaoxie.t.service.HideService;

/** 
 * MyEclipse Struts
 * Creation date: 10-21-2010
 * 
 * XDoclet definition:
 * @struts.action
 */
public class HideAction extends Action {
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
		String uids=request.getParameter("uid");
		String mids=request.getParameter("mid");
		String mCon=request.getParameter("mcon");
		try {
			mCon=new String(mCon.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int mId=Integer.parseInt(mids);
		int uId=Integer.parseInt(uids);
		Hide hide=new Hide(mCon, mId, uId);
		if(new HideService().addHide(hide)){//添加成功
		}
		return null;
	}
}