package ua.khpi.oop.lab07;

public class ActivityDigest implements Trackable, Exportable {
    private final String studentId;
    private final int completedAssignments;
    private final int totalAssignments;
    private final int forumPosts;

    public ActivityDigest(String studentId, int completedAssignments, int totalAssignments, int forumPosts) {
        this.studentId = studentId;
        this.completedAssignments = completedAssignments;
        this.totalAssignments = totalAssignments;
        this.forumPosts = forumPosts;
    }

    public String TrackingDetails() {
        return String.format("Активність %s  Виконано завдань %d/%d   Дописів на форумі %d", 
                studentId, completedAssignments, totalAssignments, forumPosts);
    }

    public double CompletionRate() {
        if (totalAssignments == 0) return 0.0;
        return ((double) completedAssignments / totalAssignments) * 100.0;
    }

    public String exportData(String format) {
        if ("JSON".equalsIgnoreCase(format)) {
            return String.format("\"studentId\": \"%s\", \"completionRate\": %.2f, \"forumPosts\": %d", 
                    studentId, CompletionRate(), forumPosts);
        }
        return studentId + CompletionRate() + forumPosts;
    }
}