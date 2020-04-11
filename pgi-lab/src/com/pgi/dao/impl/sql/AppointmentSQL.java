package com.pgi.dao.impl.sql;

public interface AppointmentSQL {
    default String getCreateAppointment() {
        String createSql = null;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into appointment values (");

        sql.append("?,");  //id
        sql.append("?,"); //patient_id
        sql.append("?,"); // doctor_id
        sql.append("?,");//dNotifyViaSms
        sql.append("?,");//dNotifyViaEmail
        sql.append("?,");//pViaSms
        sql.append("?,");//pViaEmail
        sql.append("?,");//scheduleDate
        sql.append("?,");//scheduleTime
        sql.append("?,");//scheduledDuration
        sql.append("?,");//notes
        sql.append("?,");//status
        sql.append("?,");//title
        sql.append("?,");//description
        sql.append("?,");//created_on
        sql.append("?,");//created_by
        sql.append("?,");//last_updated_on
        sql.append("?");//last_updated_by


        sql.append(");");

        createSql = sql.toString();
        return createSql;
    }


}
