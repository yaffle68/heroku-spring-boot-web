package com.heroku.demo.service;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.heroku.demo.domain.Station;
import com.heroku.demo.domain.Status;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by simon.harding on 22.03.2017.
 */
//@JsonPropertyOrder(value = {"id", "", "name", "birthday"}, alphabetic = false)
public class TimeTrackDto {
    private long id;

    private String data;
    private LocalDateTime creationTs;
    private LocalDateTime startTs;
    private LocalDateTime endTs;
    private Station station;
    private String employee;
    private long replacedBy;
    private boolean editable;
    private Status status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getStartTs() {
        return startTs;
    }

    public void setStartTs(LocalDateTime startTs) {
        this.startTs = startTs;
    }

    public LocalDateTime getEndTs() {
        return endTs;
    }

    public void setEndTs(LocalDateTime endTs) {
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
