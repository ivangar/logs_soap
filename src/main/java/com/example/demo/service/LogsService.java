package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.LogEntryEntity;
import com.example.demo.repository.LogRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogsService implements ILogsService{
    @Autowired
    private LogRepository logRepository;

    public List<LogEntryEntity> getAllLogs(){
        List<LogEntryEntity> list = new ArrayList<>();
        logRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
