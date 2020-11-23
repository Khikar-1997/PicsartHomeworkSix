package com.company.service;

import com.company.model.Student;

import java.io.File;
import java.util.Scanner;

public class StudentService {
    public static String[][] readStudentInfoFromFile(String filePath) {
        Scanner scanner;
        File file = new File(filePath);
        int count = 0;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }

            scanner = new Scanner(file);
            String[][] studentInfo = new String[count][];
            for (int i = 0; i < studentInfo.length; i++) {
                String newLine = scanner.nextLine();
                studentInfo[i] = newLine.split(",");
            }

            return studentInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Student[] createStudent(String[][] studentInfo) {
        Student[] students = new Student[studentInfo.length];

        for (int i = 0; i < studentInfo.length; i++) {
            String firstName = studentInfo[i][0];
            String lastName = studentInfo[i][1];
            int year = Integer.parseInt(studentInfo[i][2]);
            String gender = studentInfo[i][3];
            double mark = Double.parseDouble(studentInfo[i][4]);
            Student student = new Student(firstName, lastName, year, gender, mark);
            students[i] = student;
        }
        return students;
    }

    public static void printAllStudentsInfo(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void printStudentInfo(Student student) {
        System.out.println(student.toString());
    }

    //Task 1: Print full names of students
    public static void printStudentsFullName(Student[] students) {
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    //Task 2: Print all male students
    public static void printAllMaleStudents(Student[] students) {
        for (Student student : students) {
            if (student.getGender().equals("m")) {
                printStudentInfo(student);
            }
        }
    }

    //Task 3: Print all female students who has mark greater then 50.4
    public static void printAllFemaleStudentsMarkIsGreaterFiftyDothFour(Student[] students) {
        for (Student student : students) {
            if (student.getGender().equals("m") && student.getMark() > 50.4) {
                printStudentInfo(student);
            }
        }
    }

    //Task 4: Print student information having the minimal mark
    public static void printStudentInfoWithMinMark(Student[] students) {
        Student studentWithMinMark = students[0];
        for (Student student : students) {
            if (student.getMark() < studentWithMinMark.getMark()) {
                System.out.println(student.toString());
            }
        }
    }

    //Task 5: Print biggest male student information
    public static void printBiggestMaleStudentInfo(Student[] students) {
        Student student1 = students[0];
        for (Student student : students) {
            if (student.getGender().equals("m") && student.getYear() < student1.getYear()) {
                System.out.println(student.toString());
            }
        }
    }

    //Task 6: Print students sorted by mark
    private static void sortedStudents(Student[] students, int length){
        if (students.length < 2){
            return;
        }
        int mid = students.length / 2;
        Student[] students1 = new Student[mid];
        Student[] students2 = new Student[students.length - mid];
        for (int i = 0; i < students1.length; i++) {
            students1[i] = students[i];
        }
        for (int i = mid; i < students.length; i++) {
            students2[i - mid] = students[i];
        }

        sortedStudents(students1,mid);
        sortedStudents(students2,students.length - mid);
        sortStudentsInAscOrderingByMark(students,students1,students2,mid,students.length - mid);
    }

    private static void sortStudentsInAscOrderingByMark(Student[] students, Student[] students1, Student[] students2, int students1Length, int students2Length){
        int i = 0, j = 0, k = 0;
        while (i < students1Length && j < students2Length){
            if (students1[i].getMark() > students2[j].getMark()){
                students[k++] = students2[j++];
            } else {
                students[k++] = students1[i++];
            }
        }

        while (i < students1Length) {
            students[k++] = students1[i++];
        }
        while (j < students2Length) {
            students[k++] = students2[j++];
        }
    }

    public static void printStudentsSortedByMark(Student[] students){
        sortedStudents(students,students.length);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    //Task 7: Print female students sorted by year
    private static void sortedStudents1(Student[] students, int length){
        if (students.length < 2){
            return;
        }
        int mid = students.length / 2;
        Student[] students1 = new Student[mid];
        Student[] students2 = new Student[students.length - mid];
        for (int i = 0; i < students1.length; i++) {
            students1[i] = students[i];
        }
        for (int i = mid; i < students.length; i++) {
            students2[i - mid] = students[i];
        }

        sortedStudents1(students1,mid);
        sortedStudents1(students2,students.length - mid);
        sortStudentsInAscOrderingByYear(students,students1,students2,mid,students.length - mid);
    }

    private static void sortStudentsInAscOrderingByYear(Student[] students, Student[] students1, Student[] students2, int students1Length, int students2Length){
        int i = 0, j = 0, k = 0;
        while (i < students1Length && j < students2Length){
            if (students1[i].getYear() > students2[j].getYear()){
                students[k++] = students2[j++];
            } else {
                students[k++] = students1[i++];
            }
        }

        while (i < students1Length) {
            students[k++] = students1[i++];
        }
        while (j < students2Length) {
            students[k++] = students2[j++];
        }
    }

    public static void printStudentsSortedByYear(Student[] students){
        sortedStudents1(students,students.length);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
