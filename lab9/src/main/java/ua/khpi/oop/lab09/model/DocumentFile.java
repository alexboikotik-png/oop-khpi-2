package ua.khpi.oop.lab09.model;

public class DocumentFile implements CloudItem {
    private final String name;
    private final long sizeKb;
    private final int wordCount;

    public DocumentFile(String name, long sizeKb, int wordCount) {
        this.name = name;
        this.sizeKb = sizeKb;
        this.wordCount = wordCount;
    }

    public String getName() { return name; }
    
    public long getSizeKb() { return sizeKb; }
    
    public int getWordCount() { return wordCount; }

    public String toString() {
        return "Документ    Ім'я" + name + " Розмір " + sizeKb + " Слів" + wordCount;
    }
}