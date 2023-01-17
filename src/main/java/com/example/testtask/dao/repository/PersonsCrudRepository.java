package com.example.testtask.dao.repository;

import com.example.testtask.dao.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsCrudRepository extends CrudRepository<Person, Integer> {
}
