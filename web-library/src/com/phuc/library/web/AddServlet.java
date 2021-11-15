package com.phuc.library.web;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phuc.library.dao.DAO;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			add(request, response);
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		File file = new File(request.getParameter("image")); // Khai bao file textfile.txt
		String absolutePath = file.getAbsolutePath();
		String filePath = absolutePath.substring(20);

		int category_id = Integer.parseInt(request.getParameter("category_id"));
		int faculty_id = Integer.parseInt(request.getParameter("faculty_id"));
		String image = "assets/images/books/" + filePath;
		String name = request.getParameter("name");
		String name_writer = request.getParameter("name_writer");
		String language = request.getParameter("language");
		String publisher = request.getParameter("publisher");
		int num_pages = Integer.parseInt(request.getParameter("num_pages"));
		String day_print = request.getParameter("day_print");
		int status = Integer.parseInt(request.getParameter("status"));
		DAO dao = new DAO();
		dao.insertBook(category_id, faculty_id, image, name, name_writer, language, publisher, num_pages, day_print,
				status);
		response.sendRedirect("book");
	}

}
