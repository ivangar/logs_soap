package com.example.demo.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Entity
@Table(name = "logs")
public class LogEntryEntity {

    @Id
    @Column(name = "log_id")
    private int logId;

    @Column(name = "time_stamp")
    protected Timestamp timeStampCol;

    @XmlSchemaType(name = "dateTime")
    @Transient
    protected XMLGregorianCalendar timeStamp;

    @Column(name = "type_of_change")
    private int typeOfChange;

    @Column(name = "ISRC")
    private String isrc;

    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStampCol) throws DatatypeConfigurationException {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date(timeStampCol.getTime()));
        this.timeStamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(
                gc.get(GregorianCalendar.YEAR),
                gc.get(GregorianCalendar.MONTH) + 1,
                gc.get(GregorianCalendar.DAY_OF_MONTH),
                gc.get(GregorianCalendar.HOUR_OF_DAY),
                gc.get(GregorianCalendar.MINUTE),
                gc.get(GregorianCalendar.SECOND), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public Timestamp getTimeStampCol() {
        return timeStampCol;
    }

    public void setTimeStampCol(Timestamp timeStampCol) {
        this.timeStampCol = timeStampCol;
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
