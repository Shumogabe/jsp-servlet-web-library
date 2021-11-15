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
import com.phuc.library.dto.CategoryDTO;
import com.phuc.library.dto.FacultyDTO;

/**
 * Servlet implementation class BookControll
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void load(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// GET data from DAO
		DAO dao = new DAO();
		List<BookDTO> list = dao.getListBook();
		List<CategoryDTO> list1 = dao.getListCategory();
		List<FacultyDTO> list2 = dao.getListFaculty();
		// SET data to JSP
		request.setAttribute("listS", list);
		request.setAttribute("listS1", list1);
		request.setAttribute("listS2", list2);
		request.getRequestDispatcher("/View/book.jsp").forward(request, response);
	}
}
