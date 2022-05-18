package com.tectoro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tectoro.model.Books;
@Repository
public interface bookRepository extends JpaRepository<Books, Integer>{

}
