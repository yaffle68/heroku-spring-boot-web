package com.heroku.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class TimeTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private LocalDateTime creationTs;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime startTs;

    @NotNull
    private LocalTime endTs;

    @NotNull
    private Station station;

    @NotNull
    private String employee;

    private long replacedBy;

    private boolean editable;

    @NotNull
    private Status status;


    public long getId() {
        return id;
    }

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
