package com.example.metrosPj2.ichidabir;


import com.example.metrosPj2.entity.Employee;
import com.example.metrosPj2.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")


public class EmploResurs {



    private final EmployeeService employeeService;


//cONSTRUKTOR ol
    public EmploResurs(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }


    @PostMapping("/employees")
    public ResponseEntity createW(@RequestBody Employee employee) {
    Employee savedEmployee = employeeService.save(employee);
    return ResponseEntity.ok(savedEmployee);
    }


    @PutMapping("/employees")
    public ResponseEntity updateW(@RequestBody Employee employee) {

        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }
/*Bulaar bilan Bazaga yangi malumotqo;shish ,qidirb olish,
* update
 */
    @GetMapping("/employees")
    public ResponseEntity getWAll() {
        List<Employee> employeeList= employeeService.findAll();
       return ResponseEntity.ok(employeeList);
     }
    @GetMapping("/employees/{name}")
    public ResponseEntity getEmployee(@PathVariable String name) {
        List<Employee> employee1= employeeService.findName(name);
        return ResponseEntity.ok(employee1);
    }
//
//    @GetMapping("/employees/id/{id}")
//    public ResponseEntity getWById(@PathVariable Long id) {
//        Employee employee = employeeService.findId(id);
//        return ResponseEntity.ok(employee);

// Get (/api/... { } ) bir xil bo'lishi qaysi biri uchun ishlashini bilamaslik holatioga olib borishi mumkin


    @GetMapping("/employees/search")
    public ResponseEntity getAllSearch(@RequestParam String name) {
        List<Employee> employee1= employeeService.findByAllParam (name);
        return ResponseEntity.ok(employee1);

    }



    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteW(@PathVariable Long id){
        employeeService.deletes(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }



}


