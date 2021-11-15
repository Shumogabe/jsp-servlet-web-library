package com.phuc.library.dto;

public class BorrowDTO {
	int id;
	String student_id, day_borrow, day_return;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getDay_borrow() {
		return day_borrow;
	}

	public void setDay_borrow(String day_borrow) {
		this.day_borrow = day_borrow;
	}

	public String getDay_return() {
		return day_return;
	}

	public void setDay_return(String day_return) {
		this.day_return = day_return;
	}

	public BorrowDTO(int id, String student_id, String day_borrow, String day_return) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.day_borrow = day_borrow;
		this.day_return = day_return;
	}

	@Override
	public String toString() {
		return "BorrowDTO [id=" + id + ", student_id=" + student_id + ", day_borrow=" + day_borrow + ", day_return="
				+ day_return + "]";
	}

}
