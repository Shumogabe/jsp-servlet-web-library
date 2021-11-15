package com.phuc.library.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phuc.library.dao.DAO;
import com.phuc.library.dto.BorrowDTO;
import com.phuc.library.dto.BorrowDetailDTO;
import com.phuc.library.dto.ClassDTO;

/**
 * Servlet implementation class ViewBorrowDetail
 */
@WebServlet("/viewborrow")
public class ViewBorrowDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewBorrowDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			showupdate(request, response);
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

	}

	private void showupdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// GET id from JSP
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		// PASS id to DAO
		DAO dao = new DAO();
		BorrowDTO borrowDTO = dao.getListBorrowDetailFront(id);
		List<BorrowDetailDTO> borrowDetailDTO = dao.getListBorrowDetailEnd(id);
		BorrowDetailDTO borrowDetailDTO2 = dao.getCountBorrowDetail(id);
		ClassDTO classDTO =  dao.getClassBy(id);
		request.setAttribute("listS1", borrowDTO);
		request.setAttribute("listS2", borrowDetailDTO);
		request.setAttribute("borrowDetailDTO2", borrowDetailDTO2);
		request.setAttribute("classDTO", classDTO);
		System.out.println(borrowDTO);
		System.out.println(borrowDetailDTO);
		System.out.println(borrowDetailDTO2);
		System.out.println(classDTO);
		request.getRequestDispatcher("/View/borrowdetail.jsp").forward(request, response);
	}
}
