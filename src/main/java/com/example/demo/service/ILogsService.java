package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LogEntryEntity;

public interface ILogsService {
    List<LogEntryEntity> getAllLogs();
    List<LogEntryEntity> getAllLogsByChangeType(int change_type);
    List<LogEntryEntity> getAllLogsByDateRange(String from, String to);
}
