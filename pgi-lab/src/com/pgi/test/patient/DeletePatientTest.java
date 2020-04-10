package com.pgi.test.patient;

import com.pgi.dao.PatientDAO;
import com.pgi.dao.impl.PatientDAOImpl;

public class DeletePatientTest {
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAOImpl();

        final boolean delete = patientDAO.delete("PAT-1222416580559996615");
        System.out.println(delete);

    }
}
