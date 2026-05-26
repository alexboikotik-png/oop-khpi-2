package ua.khpi.oop.lab08.model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class AnalyticsRecord implements Serializable {
    private static final long serialVersionUID = 1;
    
    protected String studentId;
    protected LocalDate recordDate;

    public AnalyticsRecord(String studentId, LocalDate recordDate) {
        this.studentId = studentId;
        this.recordDate = recordDate;
    }

    public String StudentId() {
        return studentId;
    }

    public abstract String toTextLine();
}