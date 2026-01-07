public class Registration {
    private String regId;
    private Course course; 

    public Registration(String regId, Course course) {
        this.regId = regId;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "RegID: " + regId + " | " + course.toString();
    }
}