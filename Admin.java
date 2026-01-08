public class Admin extends Person {
    private String department;
    private String adminLevel;
    private boolean accessGranted;

    public Admin(String name, String id, String email, String department) {
        super(name, id, email);
        this.department = department;
        this.adminLevel = "Level 1"; 
        this.accessGranted = true;
    }

    // NEW METHOD: Admin adds a course for a specific student
    public void addStudentCourse(Student student, Course course) {
        if (accessGranted) {
            System.out.println("Admin(" + getName() + ") is adding course " + course.getCourseName() + " for " + student.getName() + "...");
            student.enroll(course); // Reuses the Student's logic (checks prereqs/capacity)
        } else {
            System.out.println("Error: Admin access denied.");
        }
    }

    // NEW METHOD: Admin removes a course for a specific student
    public void deleteStudentCourse(Student student, Course course) {
        if (accessGranted) {
            System.out.println("Admin " + getName() + " is removing course " + course.getCourseName() + " from " + student.getName() + "...");
            student.drop(course);
        } else {
            System.out.println("Error: Admin access denied.");
        }
    }

    public void revokeAccess() {
        this.accessGranted = false;
        System.out.println("Access revoked for admin: " + getName());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Admin");
        System.out.println("Department: " + department);
    }
}