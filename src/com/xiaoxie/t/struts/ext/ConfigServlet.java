package com.xiaoxie.t.struts.ext;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.xiaoxie.t.domain.UConfig;
import com.xiaoxie.t.domain.Users;
import com.xiaoxie.t.result.User_MsgSet_PageNum;
import com.xiaoxie.t.service.UConfigService;
import com.xiaoxie.t.service.UsersService;

public class ConfigServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath=this.getServletContext().getRealPath("picture");
		int maxSize=10*1000*1000;
		MultipartRequest mr=new MultipartRequest(request, uploadPath, maxSize,"UTF-8");
		String uName=mr.getParameter("cuname");
		String uTName=mr.getParameter("cutname");
		String uSex=mr.getParameter("cusex");
		String uBir=mr.getParameter("cubirth");
		String uAddr=mr.getParameter("cuaddr");
		String uQQ=mr.getParameter("cuqq");
		String uMsn=mr.getParameter("cumsn");
		String uSyn=mr.getParameter("cusyn");
		String code=mr.getParameter("code");
		HttpSession session=request.getSession(false);
		if(code.equals(session.getAttribute("rand"))){//验证码通过
			File file=mr.getFile("cupic");
			String fileName=file.getName();
			String uImg="/web_alpha/picture/"+fileName;
			User_MsgSet_PageNum umspn=(User_MsgSet_PageNum)session.getAttribute("umspn");
			Users user=umspn.getUser();
			int uId=user.getuId();
			user.setuName(uName);
			user.setuImg(uImg);
			new UsersService().updateUsers(user); //修改数据库
			umspn.setUser(user);
			session.setAttribute("umspn", umspn);
			UConfig uc=new UConfig(uId, uTName, uSex, uBir, uAddr, uQQ, uMsn, uSyn);
			if(new UConfigService().updateAndAddUC(uc)){
				response.sendRedirect("login.do");
			}
			else{
				response.sendRedirect("config.jsp");
			}
		}
		else{
			response.sendRedirect("config.jsp");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
