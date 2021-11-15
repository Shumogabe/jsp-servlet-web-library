package com.phuc.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.phuc.library.dto.BookDTO;
import com.phuc.library.dto.BorrowDTO;
import com.phuc.library.dto.BorrowDetailDTO;
import com.phuc.library.dto.CategoryDTO;
import com.phuc.library.dto.ClassDTO;
import com.phuc.library.dto.DashboardDTO;
import com.phuc.library.dto.FacultyDTO;
import com.phuc.library.dto.LibrarianDTO;

public class DAO {
	String url = "jdbc:mysql://localhost:3306/web-library?useSSL=false";
	String user = "root";
	String password = "";
	String db = "com.mysql.cj.jdbc.Driver";
	Connection conn = null;
	PreparedStatement ps = null;
	String sql = null;
	ResultSet rs = null;

	public void load(String db) {
		try {
			Class.forName(db);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			Class.forName(db);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Successful");
		} catch (SQLException e) {
			System.out.println("Fail");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// TRUY VẤN
	//

	public LibrarianDTO login(String username, String password) {
		try {
			conn = getConnection();
			sql = "SELECT * FROM librarian WHERE username = ? AND password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new LibrarianDTO(rs.getInt("id"), rs.getString("name"), rs.getString("username"),
						rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public DashboardDTO getListDashboard() {
		try {
			conn = getConnection();
			sql = "SELECT(SELECT COUNT(id) FROM books) as book,(SELECT COUNT(id) "
					+ "FROM categories) as category,(SELECT COUNT(id) FROM borrowing) as borrow";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new DashboardDTO(rs.getInt("book"), rs.getInt("category"), rs.getInt("borrow"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public BorrowDetailDTO getCountBorrowDetail(String id) {
		try {
			conn = getConnection();
			sql = "SELECT COUNT(detail_borrowing.borrowing_id) as 'borrowing_id', "
					+ "COUNT(detail_borrowing.borrowing_id) as 'book_id', "
					+ "COUNT(detail_borrowing.borrowing_id) as 'quantity' "
					+ "FROM detail_borrowing WHERE detail_borrowing.borrowing_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new BorrowDetailDTO(rs.getString("borrowing_id"), rs.getString("book_id"),
						rs.getString("quantity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<BookDTO> getListBook() {
		List<BookDTO> list = new ArrayList<>();
		try {
			conn = getConnection();
			sql = "SELECT books.id, books.image, books.name, books.name_writer, "
					+ "books.language, books.publisher, books.num_pages, books.day_print, "
					+ "books.status, categories.name AS 'category_id', faculties.name AS 'faculty_id' "
					+ "FROM books, faculties, categories WHERE books.faculty_id = faculties.id "
					+ "AND books.category_id = categories.id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BookDTO bookDTO = new BookDTO(rs.getInt("id"), rs.getInt("num_pages"), rs.getInt("status"),
						rs.getString("image"), rs.getString("name"), rs.getString("name_writer"),
						rs.getString("language"), rs.getString("publisher"), rs.getString("day_print"),
						rs.getString("category_id"), rs.getString("faculty_id"));
				list.add(bookDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<CategoryDTO> getListCategory() {
		List<CategoryDTO> list = new ArrayList<>();
		try {
			conn = getConnection();
			sql = "SELECT * FROM categories";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDTO categoryDTO = new CategoryDTO(rs.getInt("id"), rs.getString("name"));
				list.add(categoryDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<FacultyDTO> getListFaculty() {
		List<FacultyDTO> list = new ArrayList<>();
		try {
			conn = getConnection();
			sql = "SELECT * FROM faculties";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				FacultyDTO facultyDTO = new FacultyDTO(rs.getInt("id"), rs.getString("name"));
				list.add(facultyDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ClassDTO> getListClass() {
		List<ClassDTO> list = new ArrayList<>();
		try {
			conn = getConnection();
			sql = "SELECT * FROM classes";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClassDTO classDTO = new ClassDTO(rs.getInt("id"), rs.getString("name"));
				list.add(classDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BorrowDTO> getListBorrow() {
		List<BorrowDTO> list = new ArrayList<>();
		try {
			conn = getConnection();
			sql = "SELECT borrowing.id, students.name AS 'student_id', day_borrow, day_return "
					+ "FROM borrowing, students WHERE borrowing.student_id = students.id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BorrowDTO borrowDTO = new BorrowDTO(rs.getInt("id"), rs.getString("student_id"),
						rs.getString("day_borrow"), rs.getString("day_return"));
				list.add(borrowDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BorrowDTO getListBorrowDetailFront(String id) {
		try {
			conn = getConnection();
			sql = "SELECT borrowing.id, students.name AS 'student_id', day_borrow, day_return "
					+ "FROM borrowing, students WHERE borrowing.student_id = students.id AND borrowing.id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new BorrowDTO(rs.getInt("id"), rs.getString("student_id"), rs.getString("day_borrow"),
						rs.getString("day_return"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<BorrowDetailDTO> getListBorrowDetailEnd(String id) {
		List<BorrowDetailDTO> list = new ArrayList<>();
		try {
			conn = getConnection();
			sql = "SELECT detail_borrowing.borrowing_id, books.name AS 'book_id', detail_borrowing.quantity "
					+ "FROM books, detail_borrowing WHERE detail_borrowing.book_id = books.id "
					+ "AND detail_borrowing.borrowing_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				BorrowDetailDTO borrowDetailDTO = new BorrowDetailDTO(rs.getString("borrowing_id"),
						rs.getString("book_id"), rs.getString("quantity"));
				list.add(borrowDetailDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BookDTO getListBookBy(String id) {
		try {
			conn = getConnection();
			sql = "SELECT books.id, books.image, books.name, books.name_writer, books.language, "
					+ "books.publisher, books.num_pages, books.day_print, books.status, "
					+ "categories.name AS 'category_id', faculties.name AS 'faculty_id' "
					+ "FROM books, faculties, categories WHERE books.faculty_id = faculties.id "
					+ "AND books.category_id = categories.id AND books.id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new BookDTO(rs.getInt("id"), rs.getInt("num_pages"), rs.getInt("status"), rs.getString("image"),
						rs.getString("name"), rs.getString("name_writer"), rs.getString("language"),
						rs.getString("publisher"), rs.getString("day_print"), rs.getString("category_id"),
						rs.getString("faculty_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CategoryDTO getListCategoryBy(String id) {
		try {
			conn = getConnection();
			sql = "SELECT * FROM categories WHERE categories.id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new CategoryDTO(rs.getInt("id"), rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ClassDTO getClassBy(String id) {
		try {
			conn = getConnection();
			sql = "SELECT classes.id AS 'id', classes.name AS 'name' FROM classes, students, borrowing "
					+ "WHERE classes.id = students.class_id AND students.id = borrowing.student_id AND borrowing.id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ClassDTO(rs.getInt("id"), rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertBook(int category_id, int faculty_id, String image, String name, String name_writer,
			String language, String publisher, int num_pages, String day_print, int status) {
		try {
			conn = getConnection();
			sql = "INSERT INTO books (category_id, faculty_id, image, name, name_writer, language, publisher, "
					+ "num_pages, day_print, status) VALUES (?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category_id);
			ps.setInt(2, faculty_id);
			ps.setString(3, image);
			ps.setString(4, name);
			ps.setString(5, name_writer);
			ps.setString(6, language);
			ps.setString(7, publisher);
			ps.setInt(8, num_pages);
			ps.setString(9, day_print);
			ps.setInt(10, status);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCategory(String name) {
		try {
			conn = getConnection();
			sql = "INSERT INTO categories (name) VALUES (?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(int category_id, int faculty_id, String name, String name_writer, String language,
			String publisher, int num_pages, String day_print, int status, String image, int id) {
		try {
			conn = getConnection();
			sql = "UPDATE books SET category_id = ?,faculty_id = ?,name = ?,name_writer = ?,language = ?,publisher = ?,"
					+ "num_pages = ?,day_print = ?,status = ?,image = ? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category_id);
			ps.setInt(2, faculty_id);
			ps.setString(3, name);
			ps.setString(4, name_writer);
			ps.setString(5, language);
			ps.setString(6, publisher);
			ps.setInt(7, num_pages);
			ps.setString(8, day_print);
			ps.setInt(9, status);
			ps.setString(10, image);
			ps.setInt(11, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCategory(String name, int id) {
		try {
			conn = getConnection();
			sql = "UPDATE categories SET name = ? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(int id) {
		try {
			conn = getConnection();
			sql = "delete from books where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCategory(int id) {
		try {
			conn = getConnection();
			sql = "delete from categories where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
