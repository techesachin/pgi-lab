package com.pgi.test.appointment;

import com.pgi.dao.AppointmentDAO;
import com.pgi.dao.impl.AppointmentDAOImpl;
import com.pgi.domain.Appointment;
import com.pgi.utils.IdGeneratorUtil;
import com.pgi.utils.PGIDateTimeUtil;
import sun.security.x509.UniqueIdentity;

import java.util.List;

import static com.pgi.utils.PGIDateTimeUtil.getPGIDateTime;

public class CreateAppointmentTest {
    public static void main(String[] args) {
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        Appointment appointment = new Appointment();

        appointment.setId(IdGeneratorUtil.generateAppointmentId());
        appointment.setPatientId(IdGeneratorUtil.generatePatientId());
        appointment.setDoctorId(IdGeneratorUtil.generateDoctorId());
        appointment.setdNotifyViaSms(true);
        appointment.setdNotifyViaSms(true);
        appointment.setpViaSms(true);
        appointment.setpViaEmail(true);
        appointment.setScheduledDate(PGIDateTimeUtil.getDateByStringDate("2020-04-20"));
        appointment.setScheduledTime("10pm");
        appointment.setNotes("notes");
        appointment.setTitle("appointment with pgi-lab");
        appointment.setDescription("to discuss about pgi-tender");
        appointment.setScheduledDuration("2 hours");
        appointment.setStatus("Book");
        appointment.setCreatedDate(getPGIDateTime("2020-04-05 10:50:40"));
        appointment.setCreatedBy("sipu");
        appointment.setLastUpdateBy("sudhir");
        appointment.setLastUpdatedDate(getPGIDateTime("2020-04-03 08:40:12"));

        appointmentDAO.create(appointment);
        final List<Appointment> appointments = appointmentDAO.getAppointmentsByDate(PGIDateTimeUtil.getDateByStringDate("2020-04-20"));


        for (Appointment appointment1 : appointments) {
            System.out.println(appointment1);
        }


    }
}
