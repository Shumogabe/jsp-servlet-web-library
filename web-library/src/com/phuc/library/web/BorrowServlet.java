package com.phuc.library.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phuc.library.dao.DAO;
import com.phuc.library.dto.BookDTO;
import com.phuc.library.dto.BorrowDTO;
import com.phuc.library.dto.BorrowDetailDTO;
import com.phuc.library.dto.CategoryDTO;
import com.phuc.library.dto.ClassDTO;

@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorrowServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			load(request, response);
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	private void load(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// GET data from DAO
		DAO dao = new DAO();
		List<BorrowDTO> list = dao.getListBorrow();
		List<ClassDTO> classDTOs = dao.getListClass();
		List<BookDTO> bookDTOs = dao.getListBook();
		// SET data to JSP
		request.setAttribute("listS", list);
		request.setAttribute("classDTOs", classDTOs);
		request.setAttribute("bookDTOs", bookDTOs);
		request.getRequestDispatcher("/View/borrow.jsp").forward(request, response);
	}
}
