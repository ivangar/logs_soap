package com.example.demo.entity;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.datatype.XMLGregorianCalendar;

@Entity
@Table(name = "logs")
public class LogEntryEntity {

    @Id
    @Column(name = "log_id")
    private int logId;

    @Column(name = "time_stamp")
    protected Timestamp timeStamp;

    @Column(name = "type_of_change")
    private int typeOfChange;

    @Column(name = "ISRC")
    private String isrc;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getTypeOfChange() {
        return typeOfChange;
    }

    public void setTypeOfChange(int typeOfChange) {
        this.typeOfChange = typeOfChange;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }
}
