package com.pgi.test;

import com.pgi.domain.Appointment;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBUtils {

   public static Appointment getAppointmentById(String id) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "admin";
        String sqlQuery = "select * from appointment where appointment_id='" + id + "'";
        System.out.println(sqlQuery);
        Appointment appointment = new Appointment();
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {
            if (rs.next()) {
                appointment = getAppointment(rs);

            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return appointment;
    }

    private static Appointment getAppointment(ResultSet rs) throws SQLException {
       int i=1;

        Appointment appointment = new Appointment();
        appointment.setId(rs.getString(i++));
        appointment.setPatientId(rs.getString(i++));
        appointment.setDoctorId(rs.getString(i++));
        appointment.setdNotifyViaSms(rs.getBoolean(i++));
        appointment.setdNotifyViaEmail(rs.getBoolean(i++));
        appointment.setpViaSms(rs.getBoolean(i++));
        appointment.setpViaEmail(rs.getBoolean(i++));
        appointment.setScheduledDate(rs.getDate(i++));
        appointment.setScheduledTime(rs.getString(i++));
        appointment.setScheduledDuration(rs.getString(i++));
        appointment.setNotes(rs.getString(13));

        return appointment;
    }

    public static List<Appointment> getAllAppointments() {
        List<Appointment> appointmentList = new ArrayList<>();
        String GET_ALL_APPOINT_QUERY = "select * from appointment";

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "admin";
        Appointment appointment = null;
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(GET_ALL_APPOINT_QUERY)) {
            while (rs.next()) {
                appointment = getAppointment(rs);

                appointmentList.add(appointment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }

    public static List<Appointment> getAppointmentsByDate(Date scheduleDate) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "admin";
        List<Appointment> appointments = new ArrayList<>();
        String Get_All_Appointments = "select * from Appointment where scheduleddate=?";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            int i = 1;
            PreparedStatement preparedStatement = con.prepareStatement(Get_All_Appointments);
            java.sql.Date sqlDate = new java.sql.Date(scheduleDate.getTime());
            preparedStatement.setDate(i++, sqlDate);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment appointment = getAppointment(resultSet);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public static void main(String[] args) throws ParseException {

        String sDate1 = "05-04-2020";
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
        System.out.println(getAppointmentsByDate(date1));
    }
}
