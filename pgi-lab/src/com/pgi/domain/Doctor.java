package com.pgi.domain;


import java.time.LocalDateTime;

public class Doctor extends Base {
     private String id;
     private String registrationNumber;
     private String firstName;
     private String middleName;
     private String lastName;
     private String mobile;
     private String email;
     private String city;
     private String state;
     private String landMark;
   //  private String locality;
     private int pinCode;
     private String speciality;




     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getRegistrationNumber() {
          return registrationNumber;
     }

     public void setRegistrationNumber(String registrationNumber) {
          this.registrationNumber = registrationNumber;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getMiddleName() {
          return middleName;
     }

     public void setMiddleName(String middleName) {
          this.middleName = middleName;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }

     public String getMobile() {
          return mobile;
     }

     public void setMobile(String mobile) {
          this.mobile = mobile;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getCity() {
          return city;
     }

     public void setCity(String city) {
          this.city = city;
     }

     public String getState() {
          return state;
     }

     public void setState(String state) {
          this.state = state;
     }

     public String getLandMark() {
          return landMark;
     }

     public void setLandMark(String landMark) {
          this.landMark = landMark;
     }

 /*    public String getLocality() {
          return locality;
     }

     public void setLocality(String locality) {
          this.locality = locality;
     }*/

     public int getPinCode() {
          return pinCode;
     }

     public void setPinCode(int pinCode) {
          this.pinCode = pinCode;
     }

     public String getSpeciality() {
          return speciality;
     }

     public void setSpeciality(String speciality) {
          this.speciality = speciality;
     }




     @Override
     public String toString() {
          return "Doctor{" +
                  "id='" + id + '\'' +
                  ", registrationNumber='" + registrationNumber + '\'' +
                  ", firstName='" + firstName + '\'' +
                  ", middleName='" + middleName + '\'' +
                  ", lastName='" + lastName + '\'' +
                  ", mobile='" + mobile + '\'' +
                  ", email='" + email + '\'' +
                  ", city='" + city + '\'' +
                  ", state='" + state + '\'' +
                  ", landMark='" + landMark + '\'' +
                  ", pinCode='" + pinCode + '\'' +
                  ", speciality='" + speciality + '\'' +
                  '}';
     }
}
