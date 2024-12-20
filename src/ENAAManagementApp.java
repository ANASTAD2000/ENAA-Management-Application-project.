import java.util.Scanner;
import java.util.ArrayList;

public class ENAAManagementApp {
    private ArrayList<Student> students = new ArrayList<>(); // List to store students

    // Method to display main menu
    public void displayMainMenu() {
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

    // Method to display student management menu
    public void displayStudentMenu() {
        System.out.println("\n=========== Student Manager ===========");
        System.out.println("* 1. Add New Student                   *");
        System.out.println("* 2. Assign Student to Class           *");
        System.out.println("* 3. Edit Student Information          *");
        System.out.println("* 4. Delete Student                    *");
        System.out.println("* 5. View a Student                    *");
        System.out.println("* 6. Back to Main Menu                 *");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new student
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter student's age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        System.out.println("Enter student's ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        System.out.println("Enter student's email: ");
        String email = scanner.nextLine();

        System.out.println("Enter student's phone number: ");
        String phoneNumber = scanner.nextLine();

        // Create a new Student object and add it to the list
        Student student = new Student(name, age, studentId, email, phoneNumber);
        students.add(student);

        System.out.println("Student added successfully!\n");
    }

    // Method to view a specific student
    public void viewStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to view details: ");
        int id = scanner.nextInt();

        // Search for the student by ID
        for (Student student : students) {
            if (student.getStudentId() == id) {
                student.displayStudentDetails();
                return;
            }
        }

        System.out.println("Student not found.\n");
    }

    // Main method to run the application
    public static void main(String[] args) {
        ENAAManagementApp app = new ENAAManagementApp();
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            app.displayMainMenu();
            mainChoice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (mainChoice) {
                case 1:
                    int studentChoice;
                    do {
                        app.displayStudentMenu();
                        studentChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear the buffer

                        switch (studentChoice) {
                            case 1:
                                app.addStudent(); // Add a new student
                                break;
                            case 2:
                                // Logic for assigning student to class
                                break;
                            case 3:
                                // Logic for editing student information
                                break;
                            case 4:
                                // Logic for deleting student
                                break;
                            case 5:
                                app.viewStudent(); // View a student
                                break;
                            case 6:
                                System.out.println("Returning to Main Menu...\n");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.\n");
                        }
                    } while (studentChoice != 6); // Loop back to student menu
                    break;
                case 2:
                    // Manage Trainers logic
                    break;
                case 3:
                    // Manage Classes logic
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }

        } while (mainChoice != 4); // Exit the loop when the user selects option 4

        scanner.close();
    }
}
