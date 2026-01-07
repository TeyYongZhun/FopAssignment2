public class Main {

    public static void main(String[] args) {
        System.out.println("----UNIVERSITY REGISTRATION SYSTEM BOOTING----");

        // 1. DATA SETUP
        Course wix1001 = new Course("WIX1001", "Computing Mathematics", 30);
        Course wix1002 = new Course("WIX1002", "Fundamentals of Programming", 30);
        Course wix1003 = new Course("WIX1003", "Computer System and Organisation", 2); 

        // Define Logic: WIX1002 requires WIX1001
        wix1002.addPrerequisite(wix1001);

        // Create Users
        Student student = new Student("Joven Tey", "25008293", "25008293@siswa.edu.my", "Artificial Intelligence");
        Admin admin = new Admin("System Admin", "AI102332", "admin@siswa.edu.my", "IT Department");

        System.out.println(">> System initialized. Courses and Users loaded.");

        // 2. TEST USER PROFILES
        System.out.println("\n----TEST 1: DISPLAY USER PROFILES----\n");
        
        System.out.println("[Student Profile]");
        student.displayInfo();
        
        System.out.println("\n[Admin Profile]");
        admin.displayInfo(); 

        // 3. TEST ENROLLMENT LOGIC
        System.out.println("\n----TEST 2: ENROLLMENT LOGIC----\n");

        // Scenario A: Prerequisite Failure
        System.out.println(">> Attempt 1: Enroll in WIX1002 (Prereq: WIX1001)");
        System.out.println("   (Expected: FAIL - Missing Prerequisite)");
        student.enroll(wix1002); 

        // Scenario B: Success Chain
        System.out.println("\n>> Attempt 2: Enroll in WIX1001");
        System.out.println("   (Expected: SUCCESS)");
        student.enroll(wix1001);

        System.out.println("\n>> Attempt 3: Enroll in WIX1002 (Prereq now met)");
        System.out.println("   (Expected: SUCCESS)");
        student.enroll(wix1002);

        System.out.println("\n>> Attempt 4: Enroll in WIX1003");
        System.out.println("   (Expected: SUCCESS)");
        student.enroll(wix1003);

        // 4. DISPLAY SCHEDULE
        System.out.println("\n----TEST 3: CURRENT Successful Enrolment Courses----\n");
        student.displayReg();

        // 5. TEST DROPPING COURSE
        System.out.println("\n----TEST 4: DROP COURSE LOGIC----\n");
        
        System.out.println(">> Action: Dropping Computing Mathematics (WIX1001)");
        student.drop(wix1001);

        System.out.println("\n[Updated Successful Enrolment Courses]");
        student.displayReg();
    }
}