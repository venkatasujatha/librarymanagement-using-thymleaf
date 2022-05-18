package com.tectoro.service;

import com.tectoro.model.Student;

public interface service {
	public Student save(Student student);
	public boolean login(String email,String password);

}
