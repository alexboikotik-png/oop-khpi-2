package ua.khpi.oop.lab08.exception;
public class InvalidAnalyticsDataException extends Exception {
    public InvalidAnalyticsDataException(String message) {
        super(message);
    }
    
    public InvalidAnalyticsDataException(String message, Throwable cause) {
        super(message, cause);
    }
}