import java.util.Scanner;
import java.util.ArrayList;

public class ENAAManagementApp {
    // List to store students
    private ArrayList<Student> students = new ArrayList<>();

    // Method to display the menu
    public void displayMenu() {
        System.out.println("*****************************************");
        System.out.println("*          ENAA Management App          *");
        System.out.println("*****************************************");
        System.out.println("* 1. Manage Students                    *");
        System.out.println("* 2. Manage Trainers                    *");
        System.out.println("* 3. Manage Classes                     *");
        System.out.println("* 4. Exit                               *");
        System.out.println("*****************************************");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new student
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        // Input student details
        System.out.print("Enter student's ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter student's full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter student's email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student's phone number: ");
        String phoneNumber = scanner.nextLine();

        // Create a new Student object and add it to the list
        Student student = new Student(studentId, fullName, email, phoneNumber);
        students.add(student);

        System.out.println("Student added successfully!\n");
    }

    // Method to list all students
    public void listStudents() {
        System.out.println("List of all students:");
        for (Student student : students) {
            student.displayStudentDetails(); // Display each student's details
            System.out.println("-----------------------------");
        }
    }

    // Main method to start the app
    public static void main(String[] args) {
        ENAAManagementApp app = new ENAAManagementApp();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            app.displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline after the integer input

            switch (choice) {
                case 1:
                    app.addStudent(); // Call method to add a new student
                    break;
                case 2:
                    // Logic for managing trainers (to be implemented)
                    break;
                case 3:
                    // Logic for managing classes (to be implemented)
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
