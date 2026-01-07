public class Course {
    private String courseCode;
    private String courseName;
    private int capacity;
    private int enrolledCount;
    
    // Array instead of ArrayList
    private Course[] prerequisites; 
    private int prereqCount; // To track how many prerequisites are added

    public Course(String courseCode, String courseName, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledCount = 0;
        
        // Fixed size: Max 5 prerequisites allowed per course
        this.prerequisites = new Course[5]; 
        this.prereqCount = 0;
    }

    public void addPrerequisite(Course course) {
        if (prereqCount < prerequisites.length) {
            prerequisites[prereqCount] = course;
            prereqCount++;
        } else {
            System.out.println("Cannot add more prerequisites (Max 5).");
        }
    }

    public Course[] getPrerequisites() {
        return prerequisites;
    }

    public int getPrereqCount() {
        return prereqCount;
    }

    public boolean isFull() {
        return enrolledCount >= capacity;
    }

    public void addStudent() {
        if (!isFull()) enrolledCount++;
    }

    public void removeStudent() {
        if (enrolledCount > 0) enrolledCount--;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return courseCode + ": " + courseName;
    }
}