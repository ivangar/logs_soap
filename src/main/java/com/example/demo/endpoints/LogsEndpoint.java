package com.example.demo.endpoints;

import com.example.demo.repository.LogRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.entity.LogEntryEntity;
import io.spring.guides.gs_producing_web_service.LogEntry;
import io.spring.guides.gs_producing_web_service.GetAllLogsResponse;
import io.spring.guides.gs_producing_web_service.GetAllLogsByDatesRequest;
import io.spring.guides.gs_producing_web_service.GetAllLogsByDatesResponse;
import io.spring.guides.gs_producing_web_service.GetAllLogsByChangeRequest;
import io.spring.guides.gs_producing_web_service.GetAllLogsByChangeResponse;
import com.example.demo.service.ILogsService;
import persistence.helpers.LogEntryType;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class LogsEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private ILogsService logsService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllLogsRequest")
    @ResponsePayload
    public GetAllLogsResponse getAllLogs() throws DatatypeConfigurationException {
        GetAllLogsResponse response = new GetAllLogsResponse();
        List<LogEntry> LogEntryList = new ArrayList<>();
        List<LogEntryEntity> logs = logsService.getAllLogs();
        for (int i = 0; i < logs.size(); i++) {
            LogEntry log = new LogEntry();
            LogEntryEntity logEntry = logs.get(i);
            logEntry.setTimeStamp(logEntry.getTimeStampCol());
            String type_of_change = String.valueOf(LogEntryType.valueOf(logEntry.getTypeOfChangeCol()));
            logEntry.setTypeOfChange(type_of_change);
            BeanUtils.copyProperties(logEntry, log);
            log.setISRC(logEntry.getIsrc());
            LogEntryList.add(log);
        }
        response.getLogEntry().addAll(LogEntryList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllLogsByDatesRequest")
    @ResponsePayload
    public GetAllLogsByDatesResponse getAllLogsByDates(@RequestPayload GetAllLogsByDatesRequest request) throws DatatypeConfigurationException {
        String from = request.getFrom();
        String to = request.getTo();
        GetAllLogsByDatesResponse response = new GetAllLogsByDatesResponse();
        List<LogEntry> LogEntryList = new ArrayList<>();
        List<LogEntryEntity> logs = logsService.getAllLogs();
        for (int i = 0; i < logs.size(); i++) {
            LogEntry log = new LogEntry();
            LogEntryEntity logEntry = logs.get(i);
            logEntry.setTimeStamp(logEntry.getTimeStampCol());
            String type_of_change = String.valueOf(LogEntryType.valueOf(logEntry.getTypeOfChangeCol()));
            logEntry.setTypeOfChange(type_of_change);
            BeanUtils.copyProperties(logEntry, log);
            log.setISRC(logEntry.getIsrc());
            LogEntryList.add(log);
        }
        response.getLogEntry().addAll(LogEntryList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllLogsByChangeRequest")
    @ResponsePayload
    public GetAllLogsByChangeResponse getAllLogsByChange(@RequestPayload GetAllLogsByChangeRequest request) throws DatatypeConfigurationException {
        String change = request.getChangeType();
        GetAllLogsByChangeResponse response = new GetAllLogsByChangeResponse();
        List<LogEntry> LogEntryList = new ArrayList<>();
        List<LogEntryEntity> logs = logsService.getAllLogs();
        for (int i = 0; i < logs.size(); i++) {
            LogEntry log = new LogEntry();
            LogEntryEntity logEntry = logs.get(i);
            logEntry.setTimeStamp(logEntry.getTimeStampCol());
            String type_of_change = String.valueOf(LogEntryType.valueOf(logEntry.getTypeOfChangeCol()));
            logEntry.setTypeOfChange(type_of_change);
            BeanUtils.copyProperties(logEntry, log);
            log.setISRC(logEntry.getIsrc());
            LogEntryList.add(log);
        }
        response.getLogEntry().addAll(LogEntryList);
        return response;
    }
}
