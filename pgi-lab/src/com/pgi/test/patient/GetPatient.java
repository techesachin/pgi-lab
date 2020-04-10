package com.pgi.test.patient;

import com.pgi.dao.PatientDAO;
import com.pgi.dao.impl.PatientDAOImpl;
import com.pgi.domain.Patient;

public class GetPatient {
    public static void main(String[] args) {
        PatientDAO patientDAO=new PatientDAOImpl();
        final Patient patient = patientDAO.getPatientById("PAT-5087742385743577782");
        System.out.println(patient);

    }
}
