package com.pgi.test.patient;

import com.pgi.dao.PatientDAO;
import com.pgi.dao.impl.PatientDAOImpl;
import com.pgi.domain.Patient;

import java.util.List;

public class GetAllPatientTest {
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAOImpl();
        final List<Patient> patients = patientDAO.getPatients();
        /*for (Patient p : patients) {
            System.out.println(p);
        }*/

        patients.stream().forEach(patient -> {
            System.out.println(patient);
        });
        /*for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i));
        }*/


    }
}
