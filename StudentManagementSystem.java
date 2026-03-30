import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * CUSTOM EXCEPTION: StudentNotFoundException
 * Handles cases where a user tries to access or remove a record that doesn't exist.
 */
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

/**
 * STUDENT CLASS
 * Encapsulates student data and provides getters for sorting.
 */
class Student {
    private String studentId;
    private String firstName;
    private String lastName;

    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStudentId() { return studentId; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        return String.format("ID: %-10s | Name: %s %s", studentId, firstName, lastName);
    }
}

/**
 * MAIN SYSTEM CLASS
 * Manages the collection of students using ArrayList and handles sorting/exceptions.
 */
public class StudentManagementSystem {
    // Task: Use ArrayList for dynamic storage
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Student Management System Phase 2 ===");
        boolean running = true;

        while (running) {
            try {
                displayMenu();
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input); // Exception Handling: Catches non-numeric input

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> removeStudent();
                    case 3 -> sortAndDisplay("lastName");
                    case 4 -> sortAndDisplay("id");
                    case 5 -> {
                        running = false;
                        System.out.println("System closed. Good luck with the submission!");
                    }
                    default -> System.out.println("Error: Please select a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input Error: Please enter a valid numeric choice.");
            } catch (StudentNotFoundException e) {
                System.out.println("System Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1) Add New Student");
        System.out.println("2) Remove Student (by ID)");
        System.out.println("3) View List (Sorted by Last Name)");
        System.out.println("4) View List (Sorted by Student ID)");
        System.out.println("5) Exit");
        System.out.print("Selection: ");
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String fName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = scanner.nextLine();
        
        studentList.add(new Student(id, fName, lName));
        System.out.println("Student record added successfully.");
    }

    private static void removeStudent() throws StudentNotFoundException {
        System.out.print("Enter ID of student to remove: ");
        String id = scanner.nextLine();
        
        // Task: Dynamic removal using ArrayList method
        boolean found = studentList.removeIf(s -> s.getStudentId().equalsIgnoreCase(id));
        
        if (!found) {
            // Task: Custom Exception Usage
            throw new StudentNotFoundException("No record found for ID: " + id);
        }
        System.out.println("Record deleted.");
    }

    private static void sortAndDisplay(String criteria) {
        if (studentList.isEmpty()) {
            System.out.println("The list is currently empty.");
            return;
        }

        // Task: Implement sorting using Comparator
        if (criteria.equals("lastName")) {
            studentList.sort(Comparator.comparing(Student::getLastName, String.CASE_INSENSITIVE_ORDER));
            System.out.println("\n--- Students Sorted by Last Name ---");
        } else {
            studentList.sort(Comparator.comparing(Student::getStudentId));
            System.out.println("\n--- Students Sorted by ID ---");
        }

        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}