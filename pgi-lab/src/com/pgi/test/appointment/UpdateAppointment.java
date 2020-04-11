package com.pgi.test.appointment;

import com.pgi.dao.AppointmentDAO;
import com.pgi.dao.impl.AppointmentDAOImpl;
import com.pgi.domain.Appointment;

public class UpdateAppointment {

    public static void main(String[] args) {
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        final Appointment appointment = appointmentDAO.getAppointmentById("apo12345");
        appointment.setStatus("Done");
        final boolean isUpdated = appointmentDAO.updateAppointmentStatus(appointment);
        System.out.println("IsUpdate:" + isUpdated);

    }
}
