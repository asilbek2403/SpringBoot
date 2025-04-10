package com.example.metrosPj2.repository;


import com.example.metrosPj2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // FindByName va Query vas NativaQuuery bir xsil vazifa bajaradi

    List<Employee> findByName(String name);

    List<Employee> findBySurname(String surname);


    @Query("select e from Employee e  WHERE e.name = :name")
    List<Employee> findByNameQuery(@Param("name")String name);



    @Query(value = "select * from employee e WHERE e.name = :name " , nativeQuery = true)
    List<Employee> findByNameNativeQuery(@Param("name")String name);


    List<Employee> findAllByNameLike(String name);
    List<Employee> findAllByNameStartingWith(String name);
    List<Employee> findAllByNameEndingWith(String name);

    @Query("select e from Employee e WHERE e.name like concat('%', :name , '%') ")
    List<Employee> findAllByLike(@Param("name") String name);

    @Query(value = "select * from employee e WHERE e.name like %:name%",nativeQuery = true)
    List<Employee> findAllByNativeLike(@Param("name") String name);


}
