package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.vo.UserVo;

public class WriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		if(session.getAttribute("authUser") == null){ // 로그인 안했을 시
			HttpUtil.redirect(response, "/mysite0/user?a=loginform");
			return;
		}
				
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/write.jsp");
	}

}
