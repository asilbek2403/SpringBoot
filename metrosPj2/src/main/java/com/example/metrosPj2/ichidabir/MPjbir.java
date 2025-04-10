package com.example.metrosPj2.ichidabir;


import com.example.metrosPj2.ichidaikki.Doctor;
import com.example.metrosPj2.ichidaikki.NamunaPatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class MPjbir {
//
//    @GetMapping("/students")
//    public String study() {
//        return "Study with Spring Boot";
//    }
    // bir xil funksiyalar yaratamiz  Bizda Error beradi Aetibor beramiz



    @PostMapping("/students")
    public ResponseEntity creatW(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctor);

    }


    @PostMapping("/students/list")
    public ResponseEntity listss(@RequestBody List<Doctor> list) {
        return ResponseEntity.ok(list);

    }


    @PutMapping("/students")
    public ResponseEntity updateW(@RequestBody Doctor doc){
        doc.setAge(99);
        return ResponseEntity.ok(doc);

    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateW(@PathVariable Long id,
                                        @RequestBody Doctor doc){
            doc.setId(id);
            doc.setName("URA!!");
            return ResponseEntity.ok(doc);

    }


    @GetMapping("/students/{id}")
    public ResponseEntity<?> getW(@PathVariable Long id) {
        Doctor doc = new Doctor();
        doc.setId(id);
        return ResponseEntity.ok(doc);
    }
//    Bunda||<> Yangi obyekt yaratib unga id berishni va obyektni qaytaradi


    @GetMapping("/students")
    public ResponseEntity findAll(
                                @RequestParam Long id,
                                @RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam Integer age){
        List<Doctor> doclist= new ArrayList<>();
        Doctor doc = new Doctor();
//        doc.setId(100L);
//        doc.setName("Intelleging Disk!!");

        NamunaPatch patch = new NamunaPatch();
        patch.setId(4);
        patch.setName("Patchda ishlar Yangi Course class bilan");
        doclist.add(new Doctor(name , surname , id, age,patch));
        doclist.add(new Doctor("namelar","surnamelar",50L,88,patch));


        return ResponseEntity.ok(doclist);

    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteW(@PathVariable Long id){
        return ResponseEntity.ok("MAlumot o'chirdim");
    }


    @PatchMapping("/students/{id}")
    public ResponseEntity patchdataW(@PathVariable Long id,
                                     @RequestBody Doctor doc){
        return ResponseEntity.ok(doc);

    }



}
