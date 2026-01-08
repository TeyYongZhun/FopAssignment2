public class Registration {
    private String semester;
    private Course course; 
    private String status;

    public Registration(Course course) {
        this.semester = "Sem 1";
        this.course = course;
        this.status = "Active";
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Semester: " + semester + " | Status: " + status + " | " + course.toString();
    }
}