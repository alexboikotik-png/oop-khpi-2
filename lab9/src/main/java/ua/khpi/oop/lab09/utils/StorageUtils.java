package ua.khpi.oop.lab09.utils;

import ua.khpi.oop.lab09.container.CloudRecord;
import ua.khpi.oop.lab09.model.CloudItem;
import java.util.List;

public class StorageUtils {
    
    public static <T extends CloudItem> long calculateTotalSize(List<CloudRecord<T>> records) {
        long totalSize = 0;
        for (CloudRecord<T> record : records) {
            totalSize += record.getRecordSize();
        }
        return totalSize;
    }
}