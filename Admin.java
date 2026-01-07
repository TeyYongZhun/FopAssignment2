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