public class Admin extends Person {
    private String department;
    private int adminLevel;
    private boolean accessGranted=false;

    public Admin(String name, String id, String email, String department, int adminLevel) {
        super(name, id, email);
        this.department = department;
        this.adminLevel = adminLevel; 
    }

    public void getAccess(int adminLevel){
        if (adminLevel>=2){
            this.accessGranted=true;
        }
    }

    // NEW METHOD: Admin adds a course for a specific student
    public void addStudentCourse(Student student, Course course) {
        getAccess(this.adminLevel);
        if (accessGranted) {
            System.out.println("Admin(" + getName() + ") is adding course " + course.getCourseName() + " for " + student.getName() + "...");
            student.enroll(course); // Reuses the Student's logic (checks prereqs/capacity)
        } else {
            System.out.println("Error: Admin access denied.");
        }
    }

    // NEW METHOD: Admin removes a course for a specific student
    public void deleteStudentCourse(Student student, Course course) {
        getAccess(this.adminLevel);
        if (accessGranted) {
            System.out.println("Admin " + getName() + " is removing course " + course.getCourseName() + " from " + student.getName() + "...");
            student.drop(course);
        } else {
            System.out.println("Error: Admin access denied.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Admin");
        System.out.println("Department: " + department);
    }
}