package com.pgi.dao.impl;

import com.pgi.dao.DoctorDAO;
import com.pgi.domain.Doctor;
import com.pgi.utils.PGIDAOUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    private static final String SELECT_ALL_DOCTOR_SQL = "SELECT * FROM DOCTOR";
    private static final String SELECT_DOCTOR_ID_SQL = "SELECT * FROM DOCTOR WHERE ID=?";
    private static final String SELECT_DOCTOR_ByMobileNumber_SQL = "SELECT * FROM DOCTOR WHERE MOBILE=?";
    private static final String DELETE_DOCTOR_BY_ID_SQL = "DELETE FROM DOCTOR WHERE ID=?";
    private static final String UPDATE_DOCTOR_BY_ID_SQL = "UPDATE DOCTOR SET FIRSTNAME =? " +
            ",middleName=?,LASTNAME=?,mobile=?,email=?,city=?,d_state=?,landMark=?," +
            "pinCode=?,speciality=?,created_on=?,created_by=?,last_updated_on=?,last_updated_by=?";
    private static final String TYPE_ALL_DOCTOR_SQL = "SELECT * FROM DOCTOR";


    private static final String CREATE_DOCTOR_SQL = "insert into Doctor(\n" +
            "id,\n" +
            "registrationNumber,\n" +
            "firstName,\n" +
            "middleName,\n" +
            "lastName,\n" +
            "mobile,\n" +
            "email,\n" +
            "city,\n" +
            "d_state,\n" +
            "landMark,\n" +
            "pinCode,\n" +
            "speciality,\n" +
            "created_on,\n" +
            "created_by,\n" +
            "last_updated_on,\n" +
            "last_updated_by\n" +
            ") \n" +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    @Override
    public Doctor create(Doctor doctor) {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, CREATE_DOCTOR_SQL);
        int i = 1;
        try {
            preparedStatement.setString(i++, doctor.getId());
            preparedStatement.setString(i++, doctor.getRegistrationNumber());
            preparedStatement.setString(i++, doctor.getFirstName());
            preparedStatement.setString(i++, doctor.getMiddleName());
            preparedStatement.setString(i++, doctor.getLastName());
            preparedStatement.setString(i++, doctor.getMobile());
            preparedStatement.setString(i++, doctor.getEmail());
            preparedStatement.setString(i++, doctor.getCity());
            preparedStatement.setString(i++, doctor.getState());
            preparedStatement.setString(i++, doctor.getLandMark());
            preparedStatement.setInt(i++, doctor.getPinCode());
            preparedStatement.setString(i++, doctor.getSpeciality());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(doctor.getCreatedDate()));
            preparedStatement.setString(i++, doctor.getCreatedBy());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(doctor.getLastUpdatedDate()));
            preparedStatement.setString(i++, doctor.getLastUpdateBy());


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public boolean update(Doctor doctor) {
        boolean updated = false;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, UPDATE_DOCTOR_BY_ID_SQL);
        try {
            int i = 1;
            preparedStatement.setString(i++, doctor.getFirstName());
            preparedStatement.setString(i++, doctor.getMiddleName());
            preparedStatement.setString(i++, doctor.getLastName());
            preparedStatement.setString(i++, doctor.getMobile());
            preparedStatement.setString(i++, doctor.getEmail());
            preparedStatement.setString(i++, doctor.getCity());
            preparedStatement.setString(i++, doctor.getState());
            preparedStatement.setString(i++, doctor.getLandMark());
            preparedStatement.setInt(i++, doctor.getPinCode());
            preparedStatement.setString(i++, doctor.getSpeciality());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(doctor.getCreatedDate()));
            preparedStatement.setString(i++, doctor.getCreatedBy());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(doctor.getLastUpdatedDate()));
            preparedStatement.setString(i++, doctor.getLastUpdateBy());

           int res= preparedStatement.executeUpdate();
            if(res>0){
                updated=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public boolean delete(Doctor doctor) {
        boolean result = false;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, DELETE_DOCTOR_BY_ID_SQL);

        try {
            preparedStatement.setString(1, doctor.getId());
            int res = preparedStatement.executeUpdate();
            if (res >0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Doctor getDoctorById(String id) {
        Doctor doctor = null;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, SELECT_DOCTOR_ID_SQL);

        try {
            preparedStatement.setString(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                doctor = getDoctorFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }


    @Override
    public List<Doctor> getDoctors() {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, SELECT_ALL_DOCTOR_SQL);
        List<Doctor> doctors = null;
        try {
            final ResultSet resultSet = preparedStatement.executeQuery();
            getAllDoctorsFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    private List<Doctor> getAllDoctorsFromResultSet(ResultSet resultSet) throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        while (resultSet.next()) {

            Doctor doctor = getDoctorFromResultSet(resultSet);
            doctors.add(doctor);

        }
        return doctors;
    }

    private Doctor getDoctorFromResultSet(ResultSet resultSet) throws SQLException {
        int i = 1;

        Doctor doctor = new Doctor();
        doctor.setId(resultSet.getString(i++));
        doctor.setRegistrationNumber(resultSet.getString(i++));
        doctor.setFirstName(resultSet.getString(i++));
        doctor.setMiddleName(resultSet.getString(i++));
        doctor.setLastName(resultSet.getString(i++));
        doctor.setMobile(resultSet.getString(i++));
        doctor.setEmail(resultSet.getString(i++));
        doctor.setCity(resultSet.getString(i++));
        doctor.setState(resultSet.getString(i++));
        doctor.setLandMark(resultSet.getString(i++));

        doctor.setPinCode(resultSet.getInt(i++));
        doctor.setSpeciality(resultSet.getString(i++));
        doctor.setCreatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
        doctor.setCreatedBy(resultSet.getString(i++));
        doctor.setLastUpdatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
        doctor.setLastUpdateBy(resultSet.getString(i++));


        return doctor;
    }

    @Override
    public List<Doctor> getDoctorsByMobileNumber(String MobileNumber) {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, SELECT_DOCTOR_ByMobileNumber_SQL);
        List<Doctor> doctors = null;
        try {
            preparedStatement.setString(1, MobileNumber);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                doctors = getAllDoctorsFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public List<Doctor> getDoctors(String type) {
        Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, TYPE_ALL_DOCTOR_SQL);
        List<Doctor> doctors = null;
        try {

            preparedStatement.setString(1,type);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                doctors = getAllDoctorsFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }
}
