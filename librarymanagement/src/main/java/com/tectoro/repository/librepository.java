package com.tectoro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.tectoro.model.Student;
@Repository
public interface librepository extends JpaRepository<Student, Integer>{

	public Student findByEmail(@Param("email") String email);

}
