public class Student {

    private String studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String course;

    public Student(String studentId, String firstName, String lastName, int age, String course) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String toFileString() {
        return studentId + "," + firstName + "," + lastName + "," + age + "," + course;
    }

    public void display() {
        System.out.println(studentId + " " + firstName + " " + lastName + " Age:" + age + " Course:" + course);
    }
}
