public class Registration {
    private String regId;
    private Course course; 
    private String status;

    public Registration(String regId, Course course) {
        this.regId = regId;
        this.course = course;
        this.status = "Active";
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "RegID: " + regId + " | Status: " + status + " | " + course.toString();
    }
}