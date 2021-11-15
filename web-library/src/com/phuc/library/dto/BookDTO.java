package com.phuc.library.dto;

public class BookDTO {
	int id, num_pages, status;
	String image, name, name_writer, language, 
	publisher, day_print, category_id, faculty_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum_pages() {
		return num_pages;
	}

	public void setNum_pages(int num_pages) {
		this.num_pages = num_pages;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_writer() {
		return name_writer;
	}

	public void setName_writer(String name_writer) {
		this.name_writer = name_writer;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDay_print() {
		return day_print;
	}

	public void setDay_print(String day_print) {
		this.day_print = day_print;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}

	public BookDTO(int id, int num_pages, int status, String image, String name, String name_writer, String language,
			String publisher, String day_print, String category_id, String faculty_id) {
		super();
		this.id = id;
		this.num_pages = num_pages;
		this.status = status;
		this.image = image;
		this.name = name;
		this.name_writer = name_writer;
		this.language = language;
		this.publisher = publisher;
		this.day_print = day_print;
		this.category_id = category_id;
		this.faculty_id = faculty_id;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", num_pages=" + num_pages + ", status=" + status + ", image=" + image + ", name="
				+ name + ", name_writer=" + name_writer + ", language=" + language + ", publisher=" + publisher
				+ ", day_print=" + day_print + ", category_id=" + category_id + ", faculty_id=" + faculty_id + "]";
	}

}
