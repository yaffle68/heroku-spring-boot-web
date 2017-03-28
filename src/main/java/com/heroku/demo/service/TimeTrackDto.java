package com.heroku.demo.service;

import com.heroku.demo.domain.Station;
import com.heroku.demo.domain.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by simon.harding on 22.03.2017.
 */
//@JsonPropertyOrder(value = {"id", "", "name", "birthday"}, alphabetic = false)
public class TimeTrackDto {
    private long id;

    private LocalDateTime creationTs;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private LocalTime startTs;
    private LocalTime endTs;
    private Station station;
    private String employee;
    private long replacedBy;
    private boolean editable;
    private Status status;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTs() {
        return startTs;
    }

    public void setStartTs(LocalTime startTs) {
        this.startTs = startTs;
    }

    public LocalTime getEndTs() {
        return endTs;
    }

    public void setEndTs(LocalTime endTs) {
        this.endTs = endTs;
    }

    public LocalDateTime getCreationTs() {
        return creationTs;
    }

    public void setCreationTs(LocalDateTime creationTs) {
        this.creationTs = creationTs;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public long getReplacedBy() {
        return replacedBy;
    }

    public void setReplacedBy(long replacedBy) {
        this.replacedBy = replacedBy;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
