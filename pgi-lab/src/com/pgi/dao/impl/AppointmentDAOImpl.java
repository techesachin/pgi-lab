package com.pgi.dao.impl;

import com.pgi.dao.AppointmentDAO;
import com.pgi.domain.Appointment;

import java.util.Date;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {
    @Override
    public Appointment create(Appointment appointment) {
        return null;
    }

    @Override
    public List<Appointment> getAppointments() {
        return null;
    }

    @Override
    public List<Appointment> getAppointmentsByDate(Date appointmentDate) {
        return null;
    }

    @Override
    public boolean delete(Appointment appointment) {
        return false;
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment getAppointmentByDoctorId(String doctorId) {
        return null;
    }

    @Override
    public Appointment getAppointmentByPatientId(String doctorId) {
        return null;
    }
}
