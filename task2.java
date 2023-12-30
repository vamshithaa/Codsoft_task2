  
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] subjectMarks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            subjectMarks[i] = scanner.nextInt();
        }

        // Calculate Total Marks
        int totalMarks = calculateTotalMarks(subjectMarks);

        // Calculate Average Percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        // Grade Calculation
        char grade = assignGrade(averagePercentage);

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade:" +grade);

        // Determine Pass/Fail
        if (averagePercentage >= 50) {
            System.out.println("\nResult: Pass");
        } else {
            System.out.println("\nResult: Fail");
        }

        scanner.close();
    }

    // Function to calculate total marks
    private static int calculateTotalMarks(int[] subjectMarks) {
        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }
        return totalMarks;
    }

    // Function to calculate average percentage
    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    // Function to assign grades based on average percentage
    private static char assignGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}