public class Person {
    private String name;
    private String id;
    private String email;

    public Person(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("User: " + name);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
    }
}