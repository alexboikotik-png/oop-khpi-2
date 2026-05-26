package ua.khpi.oop.lab09.model;

public class PhotoAlbum implements CloudItem {
    private final String name;
    private final long sizeKb;
    private final int photoCount;

    public PhotoAlbum(String name, long sizeKb, int photoCount) {
        this.name = name;
        this.sizeKb = sizeKb;
        this.photoCount = photoCount;
    }

    public String getName() { return name; }
    
    public long getSizeKb() { return sizeKb; }

    public int getPhotoCount() {
        return photoCount;
    }

    public String toString() {
        return "Фото  Ім'я" + name + " Розмір = " + sizeKb + " Кількість" + photoCount;
    }
}