package com.pgi.dao.impl;

import com.pgi.dao.AppointmentDAO;
import com.pgi.dao.impl.sql.AppointmentSQL;
import com.pgi.domain.Appointment;
import com.pgi.utils.PGIDAOUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO, AppointmentSQL {

    final static String GET_ALL_APPOINTMENT = "SELECT * FROM APPOINTMENT";
    final static String DELETE_APPOINTMENT = "DELETE TABLE APPOINTMENT WHERE=?";
    final static String GET_ALL_APPOINTMENT_BY_SCHEDULED_DATE = "SELECT * FROM APPOINTMENT WHERE scheduledate=?";
    final static String UPDATE_STATUS_APPOINTMENT = "UPDATE APPOINTMENT SET STATUS=? , last_updated_by=?, last_updated_on=? WHERE ID=?";
    final static String SELECT_APPOINTMENT_GET_MOBILENUMBERBYID_SQL = "SELECT * FROM APPOINTMENT WHERE MOBILENUMBER=?";
    final static String GET_APPOINTMENT_BY_PATIENT_ID_SQL = "SELECT * FROM appointment WHERE PATIENT_ID=? ";
    final static String GET_APPOINTMENT_BY_ID = "SELECT * FROM APPOINTMENT WHERE ID =?";

    @Override
    public Appointment create(Appointment appointment) {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, getCreateAppointment());
        int i = 1;
        try {


            preparedStatement.setString(i++, appointment.getId());
            preparedStatement.setString(i++, appointment.getPatientId());
            preparedStatement.setString(i++, appointment.getDoctorId());
            preparedStatement.setBoolean(i++, appointment.isdNotifyViaSms());
            preparedStatement.setBoolean(i++, appointment.isdNotifyViaEmail());
            preparedStatement.setBoolean(i++, appointment.ispViaSms());
            preparedStatement.setBoolean(i++, appointment.ispViaEmail());
            preparedStatement.setDate(i++, new java.sql.Date(appointment.getScheduledDate().getTime())); // up casting
            preparedStatement.setString(i++, appointment.getScheduledTime());
            preparedStatement.setString(i++, appointment.getScheduledDuration());
            preparedStatement.setString(i++, appointment.getNotes());
            preparedStatement.setString(i++, appointment.getStatus());
            preparedStatement.setString(i++, appointment.getTitle());
            preparedStatement.setString(i++, appointment.getDescription());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(appointment.getCreatedDate()));
            preparedStatement.setString(i++, appointment.getCreatedBy());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(appointment.getLastUpdatedDate()));
            preparedStatement.setString(i++, appointment.getLastUpdateBy());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }


    @Override
    public List<Appointment> getAppointments() {
        final Connection connection = PGIDAOUtil.getConnection();

        PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, GET_ALL_APPOINTMENT);
        List<Appointment> appointments = new ArrayList();

        try {
            final ResultSet resultSet = preparedStatement.executeQuery();
            int i = 1;
            while (resultSet.next()) {
                final Appointment appointment = getAppointmentsFromResultSet(resultSet);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            PGIDAOUtil.closeStatement(preparedStatement);
            PGIDAOUtil.closeConnect(connection);


        }

        return appointments;
    }

    @Override
    public Appointment getAppointmentById(String id) {
        Appointment appointment = null;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, GET_APPOINTMENT_BY_ID);
        try {
            preparedStatement.setString(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                appointment = getAppointmentsFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            PGIDAOUtil.closeStatement(preparedStatement);
            PGIDAOUtil.closeConnect(connection);
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentsByDate(Date appointmentDate) {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, GET_ALL_APPOINTMENT_BY_SCHEDULED_DATE);
        List<Appointment> appointments = new ArrayList<>();
        try {
            preparedStatement.setDate(1, new java.sql.Date(appointmentDate.getTime()));
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int i = 1;
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getString(i++));
                appointment.setPatientId(resultSet.getString(i++));
                appointment.setDoctorId(resultSet.getString(i++));
                appointment.setdNotifyViaSms(resultSet.getBoolean(i++));
                appointment.setdNotifyViaEmail(resultSet.getBoolean(i++));
                appointment.setpViaSms(resultSet.getBoolean(i++));
                appointment.setpViaEmail(resultSet.getBoolean(i++));
                appointment.setScheduledDate(new Date(resultSet.getDate(i++).getTime()));
                appointment.setScheduledTime(resultSet.getString(i++));
                appointment.setScheduledDuration(resultSet.getString(i++));
                appointment.setNotes(resultSet.getString(i++));
                appointment.setStatus(resultSet.getString(i++));
                appointment.setScheduledTime(resultSet.getString(i++));
                appointment.setDescription(resultSet.getString(i++));
                appointment.setCreatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
                appointment.setCreatedBy(resultSet.getString(i++));
                appointment.setLastUpdatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
                appointment.setLastUpdateBy(resultSet.getString(i++));
                appointments.add(appointment);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    @Override
    public boolean delete(Appointment appointment) {
        boolean result = false;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, DELETE_APPOINTMENT);

        try {
            preparedStatement.setString(1, appointment.getId());
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        boolean updateAppointment = false;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = null;//PGIDAOUtil.getPreparedStatement(connection, GET_UPDATE_APPOINTMENT);
        int i = 1;
        try {
            preparedStatement.setString(i++, appointment.getStatus());
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                updateAppointment = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentByDoctorId(String doctorId) {


        return null;
    }


    private List<Appointment> getAllAppointmentsFromResultSet(ResultSet resultSet) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        while (resultSet.next()) {

            Appointment appointment = getAppointmentsFromResultSet(resultSet);
            appointments.add(appointment);

        }
        return appointments;
    }

    private Appointment getAppointmentsFromResultSet(ResultSet resultSet) {

        int i = 1;
        Appointment appointment = new Appointment();
        try {
            appointment.setId(resultSet.getString(i++));
            appointment.setPatientId(resultSet.getString(i++));
            appointment.setDoctorId(resultSet.getString(i++));
            appointment.setdNotifyViaSms(resultSet.getBoolean(i++));
            appointment.setdNotifyViaEmail(resultSet.getBoolean(i++));
            appointment.setpViaSms(resultSet.getBoolean(i++));
            appointment.setpViaEmail(resultSet.getBoolean(i++));
            appointment.setScheduledDate(resultSet.getDate(i++));
            appointment.setScheduledTime(resultSet.getString(i++));
            appointment.setScheduledDuration(resultSet.getString(i++));
            appointment.setNotes(resultSet.getString(i++));
            appointment.setStatus(resultSet.getString(i++));
            appointment.setTitle(resultSet.getString(i++));
            appointment.setDescription(resultSet.getString(i++));
            appointment.setCreatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
            appointment.setCreatedBy(resultSet.getString(i++));
            appointment.setLastUpdateBy(resultSet.getString(i++));
            appointment.setLastUpdatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }


    @Override
    public List<Appointment> getAppointmentByPatientId(String doctorId) {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, GET_APPOINTMENT_BY_PATIENT_ID_SQL);
        List<Appointment> appointments = null;

        try {
            preparedStatement.setString(1, doctorId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                appointments = getAllAppointmentsFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public boolean updateAppointmentStatus(Appointment appointment) {
        boolean result = false;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, UPDATE_STATUS_APPOINTMENT);
        appointment.setLastUpdatedDate(LocalDateTime.now());
        try {
            int i = 1;
            preparedStatement.setString(i++, appointment.getStatus());
            preparedStatement.setString(i++, appointment.getLastUpdateBy());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(appointment.getLastUpdatedDate()));

            preparedStatement.setString(i++, appointment.getId());

            final int noOfUpdatedRow = preparedStatement.executeUpdate();
            if (noOfUpdatedRow > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }
}
