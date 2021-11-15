package com.phuc.library.dto;

public class BorrowDetailDTO {
	String borrowing_id, book_id, quantity;

	public String getBorrowing_id() {
		return borrowing_id;
	}

	public void setBorrowing_id(String borrowing_id) {
		this.borrowing_id = borrowing_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public BorrowDetailDTO(String borrowing_id, String book_id, String quantity) {
		super();
		this.borrowing_id = borrowing_id;
		this.book_id = book_id;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BorrowDetailDTO [borrowing_id=" + borrowing_id + ", book_id=" + book_id + ", quantity=" + quantity
				+ "]";
	}

}
