package com.pgi.domain;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Base {

    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastUpdatedDate;
    private String lastUpdateBy;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Override
    public String toString() {
        return "Base{" +
                "createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                '}';
    }
}
