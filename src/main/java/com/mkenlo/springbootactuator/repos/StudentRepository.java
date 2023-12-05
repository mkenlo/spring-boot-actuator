package com.mkenlo.springbootactuator.repos;

import com.mkenlo.springbootactuator.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
