public class Student extends Person {
    private Registration[] registrations; 
    private int regCount; 
    private String major;
    private int totalEnrollmentAttempts; 

    public Student(String name, String id, String email, String major) {
        super(name, id, email);
        this.major = major;
        this.registrations = new Registration[10]; 
        this.regCount = 0;
        this.totalEnrollmentAttempts = 0; // <--- Initialize to 0
    }

    private boolean hasRegisteredFor(Course targetCourse) {
        for (int i = 0; i < regCount; i++) {
            if (registrations[i].getCourse() == targetCourse) {
                return true;
            }
        }
        return false;
    }

    public void enroll(Course course) {
        // 1. Check Array Limit
        if (regCount >= registrations.length) {
            System.out.println("Error: Maximum course limit reached.");
            return;
        }

        // 2. Check Course Capacity
        if (course.isFull()) {
            System.out.println("Error: " + course.getCourseName() + " is FULL.");
            return;
        }

        // 3. Check Prerequisites
        Course[] prereqs = course.getPrerequisites();
        for (int i = 0; i < course.getPrereqCount(); i++) {
            if (!hasRegisteredFor(prereqs[i])) {
                System.out.println("Error: Cannot enroll in " + course.getCourseName() 
                    + ". Missing prerequisite: " + prereqs[i].getCourseName());
                return;
            }
        }

        // 4. Check Duplicate
        if (hasRegisteredFor(course)) {
            System.out.println("Already registered for " + course.getCourseName());
        } else {
            totalEnrollmentAttempts++; // Always goes up (1, 2, 3...)
            String regID = "R" + totalEnrollmentAttempts; 
            
            registrations[regCount] = new Registration(regID, course);
            regCount++; 
            course.addStudent();
            System.out.println("Success: Enrolled in " + course.getCourseName());
        }
    }

    public void drop(Course course) {
        int index = -1;
        for (int i = 0; i < regCount; i++) {
            if (registrations[i].getCourse() == course) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < regCount - 1; i++) {
                registrations[i] = registrations[i + 1];
            }
            registrations[regCount - 1] = null;
            regCount--; // We decrease the array count, BUT NOT totalEnrollmentAttempts
            
            course.removeStudent();
            System.out.println("Success: Dropped " + course.getCourseName());
        } else {
            System.out.println("Error: You are not enrolled in " + course.getCourseName());
        }
    }

    public void displayReg() {
        System.out.println("\n--- Courses enrolled for " + getName() + " ---");
        if (regCount == 0) {
            System.out.println("No courses registered.");
        } else {
            for (int i = 0; i < regCount; i++) {
                System.out.println(registrations[i].toString());
            }
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Student");
        System.out.println("Major: " + major);
    }
}