package com.pgi.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Appointment {
   private String id;
    private String patientName;
    private String patientId;

    private String mobileNumber;
    private String emailId;
    private boolean dNotifyViaSms;
    private boolean dNotifyViaEmail;
    private boolean pViaSms;
    private boolean pViaEmail;
    private Date scheduledDate;
    private String scheduledTime;
    private String scheduledDuration;
    private String notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientId='" + patientId + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dNotifyViaSms=" + dNotifyViaSms +
                ", dNotifyViaEmail=" + dNotifyViaEmail +
                ", pViaSms=" + pViaSms +
                ", pViaEmail=" + pViaEmail +
                ", scheduledDate=" + scheduledDate +
                ", scheduledTime='" + scheduledTime + '\'' +
                ", scheduledDuration='" + scheduledDuration + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
