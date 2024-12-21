import java.util.Scanner;
import java.util.ArrayList;

public class ENAAManagementApp {
    private ArrayList<Student> students = new ArrayList<>(); // List to store students
    private int nextStudentId = 1001; // Counter for unique student IDs

    // Method to display the main menu
    public void displayMainMenu() {
        System.out.println("*****************************************");
        System.out.println("*          ENAA Management App          *");
        System.out.println("*****************************************");
        System.out.println("* 1. Manage Students                    *");
        System.out.println("* 2. Manage Trainers (not working )                   *");
        System.out.println("* 3. Manage Classes  (in progress )                  *");
        System.out.println("* 4. Exit                               *");
        System.out.println("*****************************************");
        System.out.print("Enter your choice: ");
    }

    // Method to display the student management menu
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
        scanner.nextLine(); // Clean the buffer

        System.out.println("Enter student's email: ");
        String email = scanner.nextLine();

        System.out.println("Enter student's phone number: ");
        String phoneNumber = scanner.nextLine();

        // Create a new Student object
        Student student = new Student(name, age, nextStudentId, email, phoneNumber);
        students.add(student);

        // Display the new student's ID
        System.out.println("Student added successfully!");
        System.out.println("Assigned Student ID: " + nextStudentId + "\n");

        // Increment nextStudentId for the next student
        nextStudentId++;
    }

    // Method to edit student information
    public void editStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to edit: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clean the buffer

        // Search for the student with the given studentId
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("Student found! What would you like to edit?");
                System.out.println("1. Name");
                System.out.println("2. Age");
                System.out.println("3. Email");
                System.out.println("4. Phone Number");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clean the buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        student.setName(newName); // Update the name
                        break;
                    case 2:
                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();
                        student.setAge(newAge); // Update the age
                        break;
                    case 3:
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        student.setEmail(newEmail); // Update the email
                        break;
                    case 4:
                        System.out.print("Enter new phone number: ");
                        String newPhone = scanner.nextLine();
                        student.setPhoneNumber(newPhone); // Update the phone number
                        break;
                    default:
                        System.out.println("Invalid choice. No changes made.");
                        return; // Exit if invalid choice is made
                }

                System.out.println("Student information updated successfully.\n");
                return; // Exit after updating the information
            }
        }

        // If no student was found with the given studentId
        System.out.println("Student not found.\n");
    }

    // Method to remove a student
    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to remove: ");
        int studentId = scanner.nextInt();

        // Search for the student with the given studentId
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                students.remove(student);
                System.out.println("Student with ID " + studentId + " removed successfully.\n");
                return; // Exit the method once the student is removed
            }
        }

        // If no student was found with the given studentId
        System.out.println("Student not found.\n");
    }

    // Method to view a student
    public void viewStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to view details: ");
        int studentId = scanner.nextInt();

        // Search for the student and display their details
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
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
            // Display the main menu
            app.displayMainMenu();
            mainChoice = scanner.nextInt();
            scanner.nextLine(); // Clean the buffer

            switch (mainChoice) {
                case 1:
                    int studentChoice;
                    do {
                        // Display the student management menu
                        app.displayStudentMenu();
                        studentChoice = scanner.nextInt();
                        scanner.nextLine(); // Clean the buffer

                        switch (studentChoice) {
                            case 1:
                                app.addStudent(); // Add a new student
                                break;
                            case 2:
                                // Logic for assigning a student to a class
                                break;
                            case 3:
                                app.editStudent(); // Edit student information
                                break;
                            case 4:
                                app.removeStudent(); // Remove a student
                                break;
                            case 5:
                                app.viewStudent(); // View student details
                                break;
                            case 6:
                                System.out.println("Returning to Main Menu...\n");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.\n");
                        }
                    } while (studentChoice != 6);
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

        } while (mainChoice != 4);

        scanner.close();
    }
}


