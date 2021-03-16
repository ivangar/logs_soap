package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.LogEntryEntity;

public interface LogRepository extends CrudRepository<LogEntryEntity, Integer> {

}
