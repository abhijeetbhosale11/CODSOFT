package GradeCalculator;
//*****************************This Is Abhijeet Kiran Bhosale Project*****************************//


import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");
        int numSubjects = 5; // You can change this based on the number of subjects
        int[] marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Calculate Total Marks
        int totalMarks = calculateTotalMarks(marks);

        // Calculate Average Percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);

        // Display Results
        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    // Method to calculate total marks
    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    // Method to calculate average percentage
    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    // Method to calculate grade
    private static char calculateGrade(double averagePercentage) {
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

    // Method to display results
    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
//*****************************This Is Abhijeet Kiran Bhosale Project*****************************//
