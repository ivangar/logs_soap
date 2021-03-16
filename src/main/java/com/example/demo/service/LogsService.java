package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.LogEntryEntity;
import com.example.demo.repository.LogRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogsService implements ILogsService{
    @Autowired
    private LogRepository logRepository;

    public List<LogEntryEntity> getAllLogs(){
        List<LogEntryEntity> list = new ArrayList<>();
        logRepository.findAll().forEach(e -> list.add(e));
        List<LogEntryEntity> sortedLogs = list.stream()
                .sorted((a,b) -> a.getTimeStampCol().compareTo(b.getTimeStampCol())).collect(Collectors.toList());
        return sortedLogs;
    }
}
