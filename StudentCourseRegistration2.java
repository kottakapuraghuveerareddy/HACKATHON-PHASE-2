import java.util.Scanner;
class Student {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }
    double calculateFee() {
        return courseCredits * 1500;
    }

    boolean checkEligibility() {
        return marks >= 50;
    }
    double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) {
            return fee * 0.20;
        } 
        else if (marks >= 70) {
            return fee * 0.10;
        } 
        else {
            return 0;
        }
    }
    double calculateFinalFee() {

        double fee = calculateFee();
        double scholarship = calculateScholarship();
        return fee - scholarship;
    }
    void displayDetails() {
        double fee = calculateFee();
        double scholarship = calculateScholarship();
        double finalFee = calculateFinalFee();
        System.out.println("\n===== STUDENT COURSE REGISTRATION =====");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        System.out.println("Eligibility        : Eligible");
        System.out.println("Total Fee          : Rs. " + fee);
        System.out.println("Scholarship        : Rs. " + scholarship);
        System.out.println("Final Fee          : Rs. " + finalFee);
        System.out.println("========================================");
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = sc.nextInt();
        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter course name: ");
        String courseName = sc.nextLine();
        System.out.print("Enter course credits: ");
        int courseCredits = sc.nextInt();
        Student student = new Student(
            studentName,
            rollNumber,
            marks,
            courseName,
            courseCredits
        );
        if (student.checkEligibility()) {
            student.calculateFee();
            student.calculateScholarship();
            student.calculateFinalFee();
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Failed!");
            System.out.println("Student is not eligible for registration.");
            System.out.println("Minimum marks required: 50");
        }
        sc.close();
    }
}