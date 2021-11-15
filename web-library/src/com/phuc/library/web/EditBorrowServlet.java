package com.phuc.library.web;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
import com.phuc.library.dto.DashboardDTO;
import com.phuc.library.dto.FacultyDTO;

/**
 * Servlet implementation class EditBorrowServlet
 */
@WebServlet("/editborrow")
public class EditBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBorrowServlet() {
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
		try {
			update(request, response);
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		request.getRequestDispatcher("/View/borrow_op.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// GET id from JSP
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

//		File file = new File(request.getParameter("image")); // Khai bao file textfile.txt
//		String absolutePath = file.getAbsolutePath();
//		String filePath = absolutePath.substring(20);
//
//		int category_id = Integer.parseInt(request.getParameter("category_id"));
//		int faculty_id = Integer.parseInt(request.getParameter("faculty_id"));
//		String image = "assets/images/books/" + filePath;
//		String name = request.getParameter("name");
//		String name_writer = request.getParameter("name_writer");
//		String language = request.getParameter("language");
//		String publisher = request.getParameter("publisher");
//		int num_pages = Integer.parseInt(request.getParameter("num_pages"));
//		String day_print = request.getParameter("day_print");
//		int status = Integer.parseInt(request.getParameter("status"));
//		int id = Integer.parseInt(request.getParameter("id"));
//		// PASS id to DAO
//		DAO dao = new DAO();
//		dao.updateBook(category_id, faculty_id, name, name_writer, language, publisher, num_pages, day_print, status,
//				image, id);
//		response.sendRedirect("book");
	}
}
