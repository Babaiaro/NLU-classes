import java.util.*;
import java.io.*;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        loadStudents();

        while (true) {

            System.out.println("\nStudent Management System");
            System.out.println("1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addStudent(scanner);
            } 
            else if (choice == 2) {
                viewStudents();
            } 
            else if (choice == 3) {
                break;
            }
        }
    }

    public static void addStudent(Scanner scanner) {

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("First Name: ");
        String first = scanner.nextLine();

        System.out.print("Last Name: ");
        String last = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Course: ");
        String course = scanner.nextLine();

        Student s = new Student(id, first, last, age, course);

        students.add(s);

        saveStudents();
    }

    public static void viewStudents() {

        for (Student s : students) {
            s.display();
        }
    }

    public static void saveStudents() {

        try {
            PrintWriter writer = new PrintWriter(FILE_NAME);

            for (Student s : students) {
                writer.println(s.toFileString());
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    public static void loadStudents() {

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) return;

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                Student s = new Student(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4]
                );

                students.add(s);
            }

        } catch (Exception e) {
            System.out.println("Error loading file");
        }
    }
}
