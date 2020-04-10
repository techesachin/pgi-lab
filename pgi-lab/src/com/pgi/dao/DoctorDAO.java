package com.pgi.dao;

import com.pgi.domain.Doctor;

import java.util.List;

public interface DoctorDAO {
    public Doctor create(Doctor doctor);

    public boolean update(Doctor doctor);

    public boolean delete(Doctor doctor);

    public Doctor getDoctorById(String id);

    public List<Doctor> getDoctors();

    public List<Doctor> getDoctorsByMobileNumber(String MobileNumber);

    public List<Doctor> getDoctors(String type);
}
