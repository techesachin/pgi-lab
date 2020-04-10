package com.pgi.dao.impl;

import com.pgi.dao.PatientDAO;
import com.pgi.dao.impl.sql.PatientSQL;
import com.pgi.domain.Patient;
import com.pgi.utils.PGIDAOUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatientDAOImpl implements PatientDAO, PatientSQL {


    @Override
    public Patient create(Patient patient) {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, getCreatePatientSQL());
        boolean result = false;
        int i = 1;
        try {
            preparedStatement.setString(i++, "PAT-" + new Random().nextLong());
            preparedStatement.setString(i++, patient.getFirstName());
            preparedStatement.setString(i++, patient.getMiddleName());
            preparedStatement.setString(i++, patient.getLastName());
            preparedStatement.setString(i++, patient.getMobile());
            preparedStatement.setString(i++, patient.getEmail());
            preparedStatement.setString(i++, patient.getCity());
            preparedStatement.setString(i++, patient.getState());
            preparedStatement.setString(i++, patient.getLandMark());
            preparedStatement.setInt(i++, patient.getPinCode());
            preparedStatement.setFloat(i++, patient.getWeight());
            preparedStatement.setFloat(i++, patient.getHeight());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(patient.getCreatedDate()));
            preparedStatement.setString(i++, patient.getCreatedBy());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(patient.getLastUpdatedDate()));
            preparedStatement.setString(i++, patient.getLastUpdateBy());
            final int res = preparedStatement.executeUpdate();
            if (res > 0) {
                result = true;
                System.out.println("Patient is created successfully in Data base");
            }


        } catch (SQLException e) {
            System.out.println("Some  error occurred while creating the Patient");
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public boolean update(Patient patient) {
        boolean updated = false;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, getUpdatePatientSQL());
        int i = 1;
        try {
            preparedStatement.setString(i++, patient.getId());
            preparedStatement.setString(i++, patient.getFirstName());
            preparedStatement.setString(i++, patient.getMiddleName());
            preparedStatement.setString(i++, patient.getLastName());
            preparedStatement.setString(i++, patient.getMobile());
            preparedStatement.setString(i++, patient.getEmail());
            preparedStatement.setString(i++, patient.getCity());
            preparedStatement.setString(i++, patient.getState());
            preparedStatement.setString(i++, patient.getLandMark());
            preparedStatement.setInt(i++, patient.getPinCode());
            preparedStatement.setFloat(i++, patient.getHeight());
            preparedStatement.setFloat(i++, patient.getWeight());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(patient.getCreatedDate()));
            preparedStatement.setString(i++, patient.getCreatedBy());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(patient.getLastUpdatedDate()));
            preparedStatement.setString(i++, patient.getLastUpdateBy());


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, DELETE__PATIENT_BY_ID_SQL);

        try {
            preparedStatement.setString(1, id);
            final int i = preparedStatement.executeUpdate();
            if (i > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Patient getPatientById(String id) {
        Patient patient = null;
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, getPatientSQL());
        try {

            preparedStatement.setString(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                patient = getPatientFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    private Patient getPatientFromResultSet(ResultSet resultSet) {
        Patient patient = new Patient();
        int i = 1;
        try {

            patient.setId(resultSet.getString(i++));
            patient.setFirstName(resultSet.getString(i++));
            patient.setMiddleName(resultSet.getString(i++));
            patient.setLastName(resultSet.getString(i++));
            patient.setMobile(resultSet.getString(i++));
            patient.setEmail(resultSet.getString(i++));
            patient.setCity(resultSet.getString(i++));
            patient.setState(resultSet.getString(i++));
            patient.setLandMark(resultSet.getString(i++));
            patient.setPinCode(resultSet.getInt(i++));
            patient.setWeight(resultSet.getFloat(i++));
            patient.setHeight(resultSet.getFloat(i++));
            patient.setCreatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
            patient.setCreatedBy(resultSet.getString(i++));
            patient.setLastUpdatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
            patient.setLastUpdateBy(resultSet.getString(i++));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }


    @Override
    public List<Patient> getPatients() {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, GET_ALL_PATIENT_SQL);
        List<Patient> patients = null;
        try {
            final ResultSet resultSet = preparedStatement.executeQuery();
            patients = getAllPatientsFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    private List<Patient> getAllPatientsFromResultSet(ResultSet resultSet) throws SQLException {
        List<Patient> patients = new ArrayList<>();
        while (resultSet.next()) {

            Patient patient = getPatientsFromResultSet(resultSet);
            patients.add(patient);

        }
        return patients;
    }

    private Patient getPatientsFromResultSet(ResultSet resultSet) throws SQLException {
        int i = 1;
        Patient patient = new Patient();
        patient.setId(resultSet.getString(i++));
        patient.setFirstName(resultSet.getString(i++));
        patient.setMiddleName(resultSet.getString(i++));
        patient.setLastName(resultSet.getString(i++));
        patient.setMobile(resultSet.getString(i++));
        patient.setEmail(resultSet.getString(i++));
        patient.setCity(resultSet.getString(i++));
        patient.setState(resultSet.getString(i++));
        patient.setLandMark(resultSet.getString(i++));
        patient.setPinCode(resultSet.getInt(i++));
        patient.setWeight(resultSet.getFloat(i++));
        patient.setHeight(resultSet.getFloat(i++));
        patient.setCreatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
        patient.setCreatedBy(resultSet.getString(i++));
        patient.setLastUpdatedDate(resultSet.getTimestamp(i++).toLocalDateTime());
        patient.setLastUpdateBy(resultSet.getString(i++));
        return patient;

    }


    @Override
    public List<Patient> getPatientsByMobileNumber(String MobileNumber) {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, CREATE_PATIENT_BY_MOBILENUMBER_SQL);
        List<Patient> patients = null;
        try {
            preparedStatement.setString(1, MobileNumber);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                patients = getAllPatientsFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;

    }

    @Override
    public List<Patient> getPatients(String type) {
        final Connection connection = PGIDAOUtil.getConnection();
        final PreparedStatement preparedStatement = PGIDAOUtil.getPreparedStatement(connection, TYPE_ALL_PATIENT_SQL);
        List<Patient> patients = null;

        try {
            preparedStatement.setString(1, type);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                patients = getAllPatientsFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
