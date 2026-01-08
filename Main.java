public class Main {

    public static void main(String[] args) {
        System.out.println("----UNIVERSITY REGISTRATION SYSTEM BOOTING----");

        // 1. DATA SETUP
        Course wix1001 = new Course("WIX1001", "Computing Mathematics", 30);
        Course wix1002 = new Course("WIX1002", "Fundamentals of Programming", 30);
        Course wix1003 = new Course("WIX1003", "Computer System and Organisation", 1); 

        // Define Logic: WIX1002 requires WIX1001
        wix1002.addPrerequisite(wix1001);
        wix1003.addPrerequisite(wix1002);

        // Create Users
        Student student1 = new Student("Joven Tey", "25008293", "25008293@siswa.edu.my", "Artificial Intelligence");
        Student student2 = new Student("Ali", "25008294", "25008294@siswa.edu.my", "Artificial Intelligence");
        Admin admin = new Admin("Staff UM", "AI102332", "admin@siswa.edu.my", "IT Department");

        System.out.println(">> System initialized. Courses and Users loaded.");

        System.out.println("\n---- COURSE CATALOG (AVAILABLE FOR REGISTRATION) ----");
        System.out.println("1. " + wix1001.toString());
        System.out.println("2. " + wix1002.toString());
        System.out.println("3. " + wix1003.toString());

        // 2. TEST USER PROFILES
        System.out.println("\n----TEST 1: DISPLAY USER PROFILES----\n");
        
        System.out.println("[Student Profile]");
        student1.displayInfo();
        
        System.out.println("\n[Admin Profile]");
        admin.displayInfo(); 

        // 3. TEST ENROLLMENT LOGIC
        System.out.println("\n----TEST 2: ENROLLMENT LOGIC----\n");

        // Scenario A: Prerequisite Failure
        System.out.println("\n[Student1 Enrolling...]");
        student1.enroll(wix1003); 

        // Scenario B: Success Chain
        student1.enroll(wix1001);
        student1.enroll(wix1002);
        student1.enroll(wix1003);
        // Another student enrolling successfully
        System.out.println("\n[Student2 Enrolling...]");
        student2.enroll(wix1001);
        student2.enroll(wix1002);
        student2.enroll(wix1003);

        // 4. DISPLAY SUCCESSFUL ENROLMENTS
        System.out.println("\n----TEST 3: CURRENT Successful Enrolment Courses----");
        student1.displayReg();
        student2.displayReg();

        // 5. TEST DROPPING COURSE
        System.out.println("\n----TEST 4: DROP COURSE LOGIC----\n");
        student1.drop(wix1001);

        System.out.println("\n[Updated Successful Enrolment Courses]");
        student1.displayReg();

        // 6. TEST ADMIN ADDING/REMOVING COURSES
        System.out.println("\n----TEST 5: ADMIN MANAGING STUDENT COURSES----\n");

        // Admin adds a course (WIX1001) for the student
        admin.addStudentCourse(student1, wix1001);

        // Admin deletes a course (WIX1003) for the student
        // (Note: Student must be enrolled in WIX1003 first for this to find it, 
        // effectively testing the logic we built in previous steps)
        admin.deleteStudentCourse(student1, wix1003);

        System.out.println("\n[Final Course List for " + student1.getName() + "]");
        student1.displayReg();
    }
}