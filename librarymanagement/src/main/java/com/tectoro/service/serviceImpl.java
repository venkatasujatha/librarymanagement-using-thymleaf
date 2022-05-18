package com.tectoro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.tectoro.model.Books;
import com.tectoro.model.Student;
import com.tectoro.repository.bookRepository;
import com.tectoro.repository.librepository;
@Service
public class serviceImpl implements service {
	@Autowired
	librepository librepository;
	@Autowired
	bookRepository bookRepository;
	
	public Student save(Student student)
	{
		return librepository.save(student);
	}
	
	public List<Student> get() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean login(String email,String password) {
		
		Student student=librepository.findByEmail(email);
		if(email.equals(student.getEmail()) && password.equals(student.getPassword())) {
			return true;
		}
		
		
		return false;
	}

	public Books save(Books books) {
		return bookRepository.save(books);
		
		
	}

	
	

}
