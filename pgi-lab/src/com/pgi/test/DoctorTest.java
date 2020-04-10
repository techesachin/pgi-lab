package com.pgi.test;

import com.pgi.dao.impl.DoctorDAOImpl;
import com.pgi.domain.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class DoctorTest {
    public static void main(String[] args) {
        Random random = new Random();
        final long l = random.nextLong();
        Doctor doctor = new Doctor();
        LocalDate date=LocalDate.now();
        doctor.setId("DOC-" +date.toEpochDay());
        doctor.setFirstName("sipu");
        doctor.setEmail("sipu123@gmail.com");
        doctor.setMiddleName("kumar");
        doctor.setLastName("dubey");
        doctor.setMobile("7004634177");
        doctor.setPinCode(5000016);
        doctor.setRegistrationNumber("12345678901");
        doctor.setState("telngana");
        doctor.setSpeciality("teeth dental");
        doctor.setCity("hyd");
        doctor.setLandMark("nature ciore ");
        doctor.setCreatedBy("Sipu");
        doctor.setCreatedDate(LocalDateTime.now());
        doctor.setLastUpdateBy("Sudhir");
        doctor.setLastUpdatedDate(LocalDateTime.now());
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
        doctorDAO.create(doctor);
        doctor = doctorDAO.getDoctorById(doctor.getId());
        System.out.println(doctor);


        doctor.setFirstName("Bhantu");
        doctor.setMiddleName("Dubey");
        doctorDAO.update(doctor);

        doctor = doctorDAO.getDoctorById(doctor.getId());
        System.out.println(doctor);
        doctor.setId("21231");
      //  System.out.println("deleted =" + doctorDAO.delete(doctor));
        //  doctor.setMobile("7004954054");
        // doctorDAO.update(doctor);

    }
}
