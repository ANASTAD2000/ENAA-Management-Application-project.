public class Student {
    private String name;
    private int age;
    private int studentId;
    private String email;
    private String phoneNumber;

    // Constructor
    public Student(String name, int age, int studentId, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter method for studentId
    public int getStudentId() {
        return studentId;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
