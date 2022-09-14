package com.poly.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.model.Customes;

public interface CustomerRepository extends JpaRepository<Customes, Long>{
	@Query(value = "SELECT * FROM employee left join categoryid "
			+ "as o on o.id = employee.categoryid WHERE employee.status <> '1' "
			+ "AND employee.name LIKE '%''%'"
			+ "AND employee.address LIKE '%''%'%"
			+ "AND employee.categoryid LIKE '%1%' ",nativeQuery = true)
	List<Customes> findAllpro(PageRequest of);

	@Query(value = "SELECT * FROM employee WHERE employee.status <> '1' and employee.name like %:name% ",nativeQuery = true)
	Page<Customes> findAllbY(@Param("name") String name , PageRequest of);

}
