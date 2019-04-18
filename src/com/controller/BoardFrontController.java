package com.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.RequestDispatcher;
import com.service.BoardCommand;
import com.service.BoardListCommand;
import com.service.BoardReplyUICommand;
import com.service.BoardSearchCommand;
import com.service.BoardUpdateCommand;
import com.service.BoardWriteCommand;

@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {

  protected void doGet(HttpServletRequest request,
  HttpServletResponse response) throws ServletException, IOException
  {
    doPost( request, response );
  }

  protected void doPost(HttpServletRequest request,
  HttpServletResponse response) throws ServletException, IOException
  {
	request.setCharacterEncoding("EUC-KR");
    String requestURI = request.getRequestURI();
    String contextPath = request.getContextPath();
    String com = requestURI.substring(contextPath.length());

	  
    BoardCommand command = null;
    String nextPage = null;

    // 紐⑸줉 蹂닿린
    if(com.equals("/list.do")){
      command = new BoardListCommand();
      command.execute(request, response);
      nextPage = "list.jsp";
    }
    //글쓰기 폼
    if(com.equals("/writeui.do")) {
    	nextPage = "write.jsp";
    }
    //글쓰기
    if(com.equals("/write.do")) {
    	command = new BoardWriteCommand();
    	command.execute(request, response);
    	nextPage = "list.do";
    }
    
    // 湲� �닔�젙�븯湲�
    if(com.equals("/update.do")) {
    	command = new BoardUpdateCommand();
    	command.execute(request, response);
    	nextPage = "list.do";
    }
    
    // 湲� 寃��깋�븯湲�
    if(com.equals("/search.do")) {
    	command = new BoardSearchCommand();
    	command.execute(request, response);
    	nextPage = "list.jsp";
    }
    
    if(com.equals("/replyui.do")) {
    	command = new BoardReplyUICommand();
    	command.execute(request, response);
    	nextPage = "reply.jsp";
    }

    RequestDispatcher dis = request.getRequestDispatcher(nextPage);
    dis.forward(request, response);
  }
}
