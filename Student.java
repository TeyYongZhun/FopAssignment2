public class Student extends Person {
    private Registration[] registrations; 
    private int regCount; 

    // Constructor 
    public Student(String name, String id, String email) {
        super(name, id, email);
        this.registrations = new Registration[10]; // Max 10 courses
        this.regCount = 0;
    }

    // Helper: Check if student has registered for a specific course
    private boolean hasRegisteredFor(Course targetCourse) {
        for (int i = 0; i < regCount; i++) {
            if (registrations[i].getCourse() == targetCourse) {
                return true;
            }
        }
        return false;
    }

    // Method 1: Enroll
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
            // Logic: Must be currently registered for the prerequisite
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
            // Add registration
            String regID = "R" + (regCount + 1);
            registrations[regCount] = new Registration(regID, course);
            regCount++; 
            course.addStudent();
            System.out.println("Success: Enrolled in " + course.getCourseName());
        }
    }

    // Method 2: Drop
    public void drop(Course course) {
        int index = -1;
        
        // Find course index
        for (int i = 0; i < regCount; i++) {
            if (registrations[i].getCourse() == course) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Shift elements left to remove gap
            for (int i = index; i < regCount - 1; i++) {
                registrations[i] = registrations[i + 1];
            }
            registrations[regCount - 1] = null;
            regCount--;
            
            course.removeStudent();
            System.out.println("Success: Dropped " + course.getCourseName());
        } else {
            System.out.println("Error: You are not enrolled in " + course.getCourseName());
        }
    }

    // Method 3: Display
    public void displaySchedule() {
        System.out.println("\n--- Schedule for " + getName() + " ---");
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
    }
}