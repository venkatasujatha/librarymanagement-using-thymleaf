package com.tectoro.model;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Books {
	@Id
	private int id;
	private String bookname;
	private Date bookissueddate;
	private Date bookreturneddate;
	private String bookcost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Date getBookissueddate() {
		return bookissueddate;
	}
	public void setBookissueddate(Date bookissueddate) {
		this.bookissueddate = bookissueddate;
	}
	public Date getBookreturneddate() {
		return bookreturneddate;
	}
	public void setBookreturneddate(Date bookreturneddate) {
		this.bookreturneddate = bookreturneddate;
	}
	public String getBookcost() {
		return bookcost;
	}
	public void setBookcost(String bookcost) {
		this.bookcost = bookcost;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", bookname=" + bookname + ", bookissueddate=" + bookissueddate
				+ ", bookreturneddate=" + bookreturneddate + ", bookcost=" + bookcost + "]";
	}
	public Books(int id, String bookname, Date bookissueddate, Date bookreturneddate, String bookcost) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.bookissueddate = bookissueddate;
		this.bookreturneddate = bookreturneddate;
		this.bookcost = bookcost;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
