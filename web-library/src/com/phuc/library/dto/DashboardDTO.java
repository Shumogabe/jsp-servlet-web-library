package com.phuc.library.dto;

public class DashboardDTO {
	int book, category, borrow;

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getBorrow() {
		return borrow;
	}

	public void setBorrow(int borrow) {
		this.borrow = borrow;
	}

	public DashboardDTO(int book, int category, int borrow) {
		super();
		this.book = book;
		this.category = category;
		this.borrow = borrow;
	}

	@Override
	public String toString() {
		return "DashboardDTO [book=" + book + ", category=" + category + ", borrow=" + borrow + "]";
	}

}
