public class Main{
    public static void main(String[] args) {
        System.out.println("=== UNIVERSITY REGISTRATION SYSTEM ===\n");

        // 1. Create Courses
        Course wix1001 = new Course("WIX1001", "Computing Mathematics", 30);
        Course wix1002 = new Course("WIX1002", "Fundamentals of Programming", 30);
        Course wix1003 = new Course("WIX1003", "Computer System and Organisation", 2); // Small capacity for testing

        // Add Prerequisite: Must have WIX1001 to take WIX1002
        wix1002.addPrerequisite(wix1001);

        // 2. Create Users (Student and Admin)
        // Note: No major or GPA in Student constructor now
        Student student = new Student("Lily", "25008293", "25008293@siswa365.edu.my");
        Admin admin = new Admin("System Admin", "AI102332", "admin@siswa365.edu.my   ", "IT Department");

        // 3. Display User Info
        student.displayInfo();
        admin.displayInfo(); // Satisfies "2 subclasses" requirement

        System.out.println("----------------------------------------");

        // 4. SCENARIO: Enroll
        System.out.println(">> Attempt: Enroll in Computing Mathematics (WIX1001)");
        // This should FAIL because Alice doesn't have WIX1001 yet
        student.enroll(wix1002); 

        System.out.println("\n>> Attempt: Enroll in Computing Mathematics (WIX1001)");
        // This should SUCCEED
        student.enroll(wix1001);
        System.out.println("\n>> Attempt: Enroll in Fundamentals of Programming (WIX1002)");
        // This should SUCCEED now (because Alice has WIX1001)
        student.enroll(wix1002);

        System.out.println("\n>> Attempt: Enroll in Computer System and Organisation(WIX1003)");
        student.enroll(wix1003);

        // 5. Display Schedule
        student.displaySchedule();

        // 6. SCENARIO: Drop
        System.out.println("\n----------------------------------------");
        System.out.println(">> Action: Dropping Computing Mathematics (WIX1001)");
        student.drop(wix1001);

        // 7. Final Schedule Display
        student.displaySchedule();
    }
}