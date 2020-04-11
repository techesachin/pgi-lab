package com.pgi.dao;

import com.pgi.domain.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentDAO {
    public Appointment create(Appointment appointment);

    public List<Appointment> getAppointments();

    public Appointment getAppointmentById(String id);

    public List<Appointment> getAppointmentsByDate(Date appointmentDate);

    public boolean delete(Appointment appointment);

    public Appointment updateAppointment(Appointment appointment);

    public List<Appointment> getAppointmentByDoctorId(String doctorId);

    public List<Appointment> getAppointmentByPatientId(String patientId);

    public boolean updateAppointmentStatus(Appointment appointment);


}
