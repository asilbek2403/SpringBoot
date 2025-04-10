package com.example.metrosPj2.service;

import com.example.metrosPj2.entity.Employee;
import com.example.metrosPj2.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service

public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeService( EmployeeRepository employeeRepository1) {
        this.employeeRepository = employeeRepository1;
    }


    public Employee save(Employee employee) {
        return employeeRepository.save(employee);

    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findId(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findName(String name){
     return employeeRepository.findByNameNativeQuery(name);
    }

  //////Like FIND

    public List<Employee> findByAllParam(String name){
        return employeeRepository.findAllByNameStartingWith(name);
    }


    public void deletes(Long id){
        //Employee employee = employeeRepository.getOne(id);
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Employee with id " + id + " not found");
        }
    }

//    @Scheduled(cron = "0 52 6 * * *")
//    public Employee SaveShedule(){
//        Employee employee = new Employee();
//        employee.setName(" Cronda ishcontr");
//        employee.setSurname("Qanchadir cronlik");
//        return employeeRepository.save(employee);
//    } ishladi bu ham

}
