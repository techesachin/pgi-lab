package com.pgi.service;

import com.pgi.domain.Appointment;
import com.pgi.utils.PGIDateTimeUtil;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AppointmentService {
    static Map<String, List<Appointment>> appointmentsByDate = new HashMap<>();

    public static void main(String[] args) {
        List<Appointment> appointments1 = getAppointments();
        List<Appointment> appointments2 = getAppointments();
        // 05-04-2020
        String date1 = "05-04-2020";
        String date2 = "04-04-2020";

        appointmentsByDate.put(date1, appointments1);
        appointmentsByDate.put(date2, appointments2);
        System.out.println(getAppointmentsByDate(date1));

    }

    private static List<Appointment> getAppointmentsByDate(String date) {
        return appointmentsByDate.get(date);
    }

    private static List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();


        Appointment appointment1 = new Appointment();
        appointment1.setScheduledDate(PGIDateTimeUtil.getDateByStringDate("2020-04-20"));
        appointment1.setScheduledDuration("30:min");
        appointment1.setScheduledTime("10am t0 5am");
        appointment1.setpViaSms(false);
        appointment1.setpViaEmail(true);

        appointment1.setPatientId("12345@");
        appointment1.setNotes("abc");

        appointment1.setdNotifyViaSms(true);
        appointment1.setdNotifyViaEmail(false);

        appointments.add(appointment1);
        Appointment appointment2 = new Appointment();
        appointment2.setScheduledDate(PGIDateTimeUtil.getDateByStringDate("2020-04-20"));
        appointment2.setScheduledDuration("30:min");
        appointment2.setScheduledTime("10am t0 5am");
        appointment2.setpViaSms(false);
        appointment2.setpViaEmail(true);

        appointment2.setPatientId("12345@");
        appointment2.setNotes("abc");

        appointment2.setdNotifyViaSms(true);
        appointment2.setdNotifyViaEmail(false);

        appointments.add(appointment2);


        Appointment appointment3 = new Appointment();
        appointment3.setScheduledDate(PGIDateTimeUtil.getDateByStringDate("2020-04-20"));
        appointment3.setScheduledDuration("30:min");
        appointment3.setScheduledTime("10am t0 5am");
        appointment3.setpViaSms(false);
        appointment3.setpViaEmail(true);

        appointment3.setPatientId("12345@");
        appointment3.setNotes("abc");

        appointment3.setdNotifyViaSms(true);
        appointment3.setdNotifyViaEmail(false);

        appointments.add(appointment3);
        return appointments;
    }
}


