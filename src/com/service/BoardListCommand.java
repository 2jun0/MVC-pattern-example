package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.dao.BoardDAO;
import com.entity.BoardDTO;

public class BoardListCommand implements BoardCommand {
  public void execute(HttpServletRequest request, HttpServletResponse response){
    BoardDAO dao = new BoardDAO();
    ArrayList<BoardDTO> list = dao.list();

    request.setAttribute("list", list);
  }
}