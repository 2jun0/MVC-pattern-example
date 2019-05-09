package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.BoardDAO;

public class BoardDeleteCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num=request.getParameter("num");
		
		BoardDAO dao=new BoardDAO();
		dao.delete(num);
	}
}