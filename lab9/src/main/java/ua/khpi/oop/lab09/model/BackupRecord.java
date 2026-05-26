package ua.khpi.oop.lab09.model;

public class BackupRecord implements CloudItem {
    private final String name;
    private final long sizeKb;
    private final String version;

    public BackupRecord(String name, long sizeKb, String version) {
        this.name = name;
        this.sizeKb = sizeKb;
        this.version = version;
    }

    public String getName() { return name; }

    public long getSizeKb() { return sizeKb; }

    public String toString() {
        return "Ім'я = " + name + " Розмір = " + sizeKb + " Версія" + version;
    }
}