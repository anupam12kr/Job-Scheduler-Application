package com.myproject.JobSchedulerApplication.MyPack;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Job {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String description;
    private LocalDateTime scheduleTime;
    private String status;
    private String recurrence;
    private LocalDateTime lastRunTime;


    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getScheduleTime() {
        return this.scheduleTime;
    }
    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecurrence() {
        return this.recurrence;
    }
    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public LocalDateTime getLastRunTime() {
        return this.lastRunTime;
    }
    public void setLastRunTime(LocalDateTime lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
