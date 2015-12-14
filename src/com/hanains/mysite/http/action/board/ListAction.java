package com.hanains.mysite.http.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardListVo;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BoardDao dao = new BoardDao();
		List<BoardListVo> list = dao.getList();
		
		request.setAttribute("list", list);
				
		// 조회수 중복 증가 막기
		HttpSession session = request.getSession();
		session.setAttribute("read", "no");
		
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
