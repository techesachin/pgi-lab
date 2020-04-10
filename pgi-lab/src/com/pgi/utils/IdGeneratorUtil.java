package com.pgi.utils;

import java.util.UUID;

public class IdGeneratorUtil {
    final static String DOC_ID_PATTERN = "DOC-";
    final static String PAT_ID_PATTERN = "PAT-";
    final static String APP_ID_PATTERN = "APP-";

    public static String generatePatientId() {
        String id = null;
        UUID uuid = UUID.randomUUID();
        id = DOC_ID_PATTERN + uuid.toString();
        return id;
    }

    public static String generateDoctorId() {
        String id = null;
        UUID uuid = UUID.randomUUID();
        id = PAT_ID_PATTERN + uuid.toString();
        return id;
    }

    public static String generateAppointmentId() {
        String id = null;
        UUID uuid = UUID.randomUUID();
        id = APP_ID_PATTERN + uuid.toString();
        return id;
    }
}
