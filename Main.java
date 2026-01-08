public class Main {

    public static void main(String[] args) {
        System.out.println("----UNIVERSITY REGISTRATION SYSTEM BOOTING----");

        // 1. DATA SETUP
        Course wix1001 = new Course("WIX1001", "Computing Mathematics", 30);
        Course wix1002 = new Course("WIX1002", "Fundamentals of Programming", 30);
        Course wix1003 = new Course("WIX1003", "Computer System and Organisation", 2); 

        // Define Logic: WIX1002 requires WIX1001
        wix1002.addPrerequisite(wix1001);
        wix1003.addPrerequisite(wix1002);

        // Create Users
        Student student1 = new Student("Joven Tey", "25008293", "25008293@siswa.edu.my", "Artificial Intelligence", "Sem 1");
        Student student2 = new Student("Ali", "25008294", "25008294@siswa.edu.my", "Information System", "Sem 1");
        Student student3 = new Student("Bala", "25008295", "25008295@siswa.edu.my", "Software Engineering", "Sem 1");
        Admin admin1 = new Admin("Staff Engineering UM", "AI102330", "adminEng@siswa.edu.my", "Engineering Department",1);
        Admin admin2 = new Admin("Staff FSKTM UM", "AI102332", "adminFSKTM@siswa.edu.my", "IT Department",2);

        System.out.println(">> System initialized. Courses and Users loaded.");

        System.out.println("\n---- COURSE CATALOG (AVAILABLE FOR REGISTRATION) ----");
        System.out.println("1. " + wix1001.toString());
        System.out.println("2. " + wix1002.toString());
        System.out.println("3. " + wix1003.toString());

        // 2. TEST USER PROFILES
        System.out.println("\n----TEST 1: DISPLAY USER PROFILES----\n");
        
        System.out.println("[Student Profile]");
        student1.displayInfo();
        System.out.println("");
        student2.displayInfo();
        System.out.println("");
        student3.displayInfo();
        
        System.out.println("\n[Admin Profile]");
        admin1.displayInfo(); 
        System.out.println("");
        admin2.displayInfo();

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
        // Scenario C: Course Full
        System.out.println("\n[Student3 Enrolling...]");
        student3.enroll(wix1001);
        student3.enroll(wix1002);
        student3.enroll(wix1003); // Should fail due to capacity

        // 4. DISPLAY SUCCESSFUL ENROLMENTS
        System.out.println("\n----TEST 3: CURRENT Successful Enrolment Courses----");
        student1.displayReg();
        student2.displayReg();
        student3.displayReg();

        // 5. TEST DROPPING COURSE
        System.out.println("\n----TEST 4: DROP COURSE LOGIC----\n");
        student1.drop(wix1001);

        System.out.println("\n[Updated Successful Enrolment Courses]");
        student1.displayReg();

        // 6. TEST ADMIN ADDING/REMOVING COURSES
        System.out.println("\n----TEST 5: ADMIN MANAGING STUDENT COURSES----\n");

        admin1.addStudentCourse(student3, wix1003);
        admin2.addStudentCourse(student1, wix1001);
        admin2.deleteStudentCourse(student2, wix1003);
        admin2.addStudentCourse(student3, wix1003);


        System.out.println("\n[Final Course List for Students]");
        student1.displayReg();
        student2.displayReg();
        student3.displayReg();
    }
}