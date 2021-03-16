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
import io.spring.guides.gs_producing_web_service.GetAllLogsRequest;
import io.spring.guides.gs_producing_web_service.GetAllLogsResponse;
import io.spring.guides.gs_producing_web_service.GetLogsRequest;
import io.spring.guides.gs_producing_web_service.GetLogsResponse;
import io.spring.guides.gs_producing_web_service.ServiceStatus;
import com.example.demo.service.ILogsService;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class LogsEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private ILogsService logsService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllLogsRequest")
    @ResponsePayload
    public GetAllLogsResponse GetAllLogs() {
        GetAllLogsResponse response = new GetAllLogsResponse();
        List<LogEntry> LogEntryList = new ArrayList<>();
        List<LogEntryEntity> logs = logsService.getAllLogs();
        for (int i = 0; i < logs.size(); i++) {
            LogEntry log = new LogEntry();
            BeanUtils.copyProperties(logs.get(i), log);
            LogEntryList.add(log);
        }
        response.getLogEntry().addAll(LogEntryList);
        return response;
    }
}
