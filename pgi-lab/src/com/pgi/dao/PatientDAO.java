package com.pgi.dao;

import com.pgi.domain.Patient;

import java.util.List;

public interface PatientDAO {
    public Patient create(Patient patient);

    public boolean update(Patient patient);

    public boolean delete(String id);

    public Patient getPatientById(String id);

    public List<Patient> getPatients();

    public List<Patient> getPatientsByMobileNumber(String MobileNumber);

    public List<Patient> getPatients(String type);

}
