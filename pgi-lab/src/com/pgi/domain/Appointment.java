package com.pgi.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Appointment extends Base {
    private String id;
    private String patientId;
    private String doctorId;
    private boolean dNotifyViaSms;
    private boolean dNotifyViaEmail;
    private boolean pViaSms;
    private boolean pViaEmail;
    private Date scheduledDate;
    private String scheduledTime;
    private String scheduledDuration;
    private String notes;
    private String status;
    private String title;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public boolean isdNotifyViaSms() {
        return dNotifyViaSms;
    }

    public void setdNotifyViaSms(boolean dNotifyViaSms) {
        this.dNotifyViaSms = dNotifyViaSms;
    }

    public boolean isdNotifyViaEmail() {
        return dNotifyViaEmail;
    }

    public void setdNotifyViaEmail(boolean dNotifyViaEmail) {
        this.dNotifyViaEmail = dNotifyViaEmail;
    }

    public boolean ispViaSms() {
        return pViaSms;
    }

    public void setpViaSms(boolean pViaSms) {
        this.pViaSms = pViaSms;
    }

    public boolean ispViaEmail() {
        return pViaEmail;
    }

    public void setpViaEmail(boolean pViaEmail) {
        this.pViaEmail = pViaEmail;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getScheduledDuration() {
        return scheduledDuration;
    }

    public void setScheduledDuration(String scheduledDuration) {
        this.scheduledDuration = scheduledDuration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", dNotifyViaSms=" + dNotifyViaSms +
                ", dNotifyViaEmail=" + dNotifyViaEmail +
                ", pViaSms=" + pViaSms +
                ", pViaEmail=" + pViaEmail +
                ", scheduledDate=" + scheduledDate +
                ", scheduledTime='" + scheduledTime + '\'' +
                ", scheduledDuration='" + scheduledDuration + '\'' +
                ", notes='" + notes + '\'' +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

