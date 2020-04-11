package com.pgi.test.patient;

import com.pgi.dao.PatientDAO;
import com.pgi.dao.impl.PatientDAOImpl;
import com.pgi.domain.Patient;

import java.time.LocalDateTime;

public class CreatePatientTest {
    public static void main(String[] args) {

        // create
        // to perform crud operation
        PatientDAO patientDAO = new PatientDAOImpl();
        // create patient object
        Patient patient = new Patient();
        patient.setId("PAT001");
        patient.setFirstName("sudhir");
        patient.setMiddleName("kumar");
        patient.setLastName("dubey");
        patient.setMobile("62000024659");
        patient.setEmail("sudhir@gmail.com");
        patient.setPinCode(5000016);
        patient.setCity("Hyderabad");
        patient.setState("telangana");
        patient.setLocality("allema temple");
        patient.setLandMark("Suprabhat Nagar");
        patient.setHeight(5.60f);
        patient.setWeight(65.0f);
        patient.setCreatedDate(LocalDateTime.now());
        patient.setCreatedBy("anup");
        patient.setLastUpdateBy("sipu");
        patient.setLastUpdatedDate(LocalDateTime.now());

        patientDAO.create(patient);


        // update
        // get by id
        // delete
        // search by mobile number
        // get all patient
        // search patient by type


    }
}
