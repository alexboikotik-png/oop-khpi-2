package ua.khpi.oop.lab13.model;

public class CampusRecord {
    private final String code;
    private final RecordType type;
    private final String time;
    private final String description;

    public CampusRecord(String code, RecordType type, String time, String description) {
        this.code = code;
        this.type = type;
        this.time = time;
        this.description = description;
    }

    public String getCode() { return code; }
    public RecordType getType() { return type; }
    public String getTime() { return time; }
    public String getDescription() { return description; }
}