package com.example.metrosPj2.repository;


import com.example.metrosPj2.entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {


    FileStorage findByHashId(String hashId);


}
