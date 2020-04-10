
create table Doctor(
    id varchar(50) primary key,
    registrationNumber varchar(50),
    firstName varchar(50),
    middleName varchar(50),
    lastName varchar(50),
    mobile varchar(15),
    email varchar(50),
    city varchar(50),
    d_state varchar(50),
    landMark text,
    pinCode int ,
    speciality varchar (50),
    created_on timestamp,
    created_by varchar(150),
    last_updated_on timestamp,
    last_updated_by varchar(150)
);
insert into Doctor(
id,
registrationNumber,
firstName,
middleName,
lastName,
mobile,
email,
city,
d_state,
landMark,
pinCode,
speciality,
created_on,
created_by,
last_updated_on,
last_updated_by
)
values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);

create table patient(
    id varchar(50) primary key,
    firstName varchar(30),
    middleName varchar(30),
    lastName varchar(30),
    mobile varchar(15),
    email varchar(50),
    city varchar(50),
    state varchar(50),
    landMark text,
    pinCode int ,
    weight decimal,
    height decimal,
    created_on timestamp,
    created_by varchar(150),
    last_updated_on timestamp,
    last_updated_by varchar(150)
);

insert into patient(
id,
firstName,
middleName,
lastName,
mobile,
email,
city,
state,
landMark,
pinCode,
weight,
height,
created_on,
created_by,
last_updated_on,
last_updated_by
)
values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);



 private String scheduledDuration;
    private String notes;
    private String status;
    private String title;
    private String description;

create table appointment(
                    id varchar(50) primary key,
                    patient_id varchar(50),
                    doctor_id varchar(50) ,
                    dNotifyViaSms boolean,
                    dNotifyViaEmail boolean,
                    pViaSms boolean,
                    pViaEmail boolean,
                    scheduleDate DATE,
                    scheduleTime varchar(50),
                    scheduledDuration varchar(50),
                    notes text,
                    status varchar(50),
                    title varchar(100),
                    description text,
                    created_on timestamp,
                    created_by  varchar(150),
                    last_updated_on timestamp,
                    last_updated_by varchar(150),
    CONSTRAINT fk_appointment_doctor_const FOREIGN KEY(doctor_id) REFERENCES doctor(id),
    CONSTRAINT fk_appointment_patient_const FOREIGN KEY(patient_id) REFERENCES patient(id)
);
insert into appointment(
id,
patient_id,
doctor_id,
dNotifyViaSms,
dNotifyViaEmail,
pViaSms,
pViaEmail,
scheduleDate,
scheduleTime,
created_on,
created_by,
last_updated_on

) values(?,?,?,?,?,?,?,?,?,?,?,?);




