package com.pgi.dao.impl.sql;

public interface PatientSQL {
    public final static String GET_ALL_PATIENT_SQL = "SELECT * FROM PATIENT";
    public final static String TYPE_ALL_PATIENT_SQL = "SELECT * FROM PATIENT";
    public final static String SELECT_PATIENT_BY_ID_SQL = "SELECT * FROM PATIENT WHERE ID=?";
    public final static String CREATE_PATIENT_BY_MOBILENUMBER_SQL = "SELECT * FROM PATIENT WHERE ID=?";
    public final static String DELETE__PATIENT_BY_ID_SQL = "DELETE FROM patient WHERE ID=?";
    public static final String UPDATE_PATIENT_BY_SQL = "UPDATE PATIENT WHERE ID=?";


    default String getCreatePatientSQL() {
        final StringBuilder createSQL = new StringBuilder();
        createSQL.append("INSERT INTO PATIENT ");
        createSQL.append(" values(");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?,");
        createSQL.append(" ?");
        createSQL.append(")");

        return createSQL.toString();
    }

    default String getSelectPatientSQL() {
        final StringBuilder selectSQL = new StringBuilder();
        selectSQL.append("SELECT * FROM PATIENT");
        return selectSQL.toString();
    }

    default String getUpdatePatientSQL() {
        final StringBuilder updateSQL = new StringBuilder();
        updateSQL.append("UPDATE PATIENT WHERE ID=?");
        //updateSQL.append(" values(");


        updateSQL.append("firstName,");
        updateSQL.append("middleName,");
        updateSQL.append("lastName,");
        updateSQL.append("mobile,");
        updateSQL.append("email,");
        updateSQL.append("city,");
        updateSQL.append("state,");
        updateSQL.append("landMark,");
        updateSQL.append("pinCode,");
        updateSQL.append("height,");
        updateSQL.append("weight,");
        updateSQL.append("created_on,");
        updateSQL.append("created_by,");
        updateSQL.append("last_updated_on,");
        updateSQL.append("last_updated_by");

        updateSQL.append(" );");

        return updateSQL.toString();
    }

    default String getPatientSQL() {
        final StringBuilder createSQL = new StringBuilder();
        createSQL.append("SELECT * FROM PATIENT WHERE ID=? ");
        return createSQL.toString();
    }


}
