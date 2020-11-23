package com.company;

import com.company.model.Student;
import com.company.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the file Path address");
        String s = scanner.nextLine();
        StudentService.readStudentInfoFromFile(s);
        Student[] students = StudentService.createStudent(StudentService.readStudentInfoFromFile(s));
        System.out.println("______________________________All Students Info_________________________");
        StudentService.printAllStudentsInfo(students);
        System.out.println("________________________________________________________________________");

        System.out.println("____________________________Students Name_______________________________");
        StudentService.printStudentsFullName(students);
        System.out.println("________________________________________________________________________");

        System.out.println("_____________________________Male Students______________________________");
        StudentService.printAllMaleStudents(students);
        System.out.println("________________________________________________________________________");

        System.out.println("______________Female Students Who Have Mark Greater 50.4________________");
        StudentService.printAllFemaleStudentsMarkIsGreaterFiftyDothFour(students);
        System.out.println("________________________________________________________________________");

        System.out.println("_______________________Students With Min Mark___________________________");
        StudentService.printStudentInfoWithMinMark(students);
        System.out.println("________________________________________________________________________");

        System.out.println("_________________________Student By Biggest Male________________________");
        StudentService.printBiggestMaleStudentInfo(students);
        System.out.println("________________________________________________________________________");

        System.out.println("_____________________Students Info Sorted By Mark_______________________");
        StudentService.printStudentsSortedByMark(students);
        System.out.println("________________________________________________________________________");

        System.out.println("_____________________Students Info Sorted By Year_______________________");
        StudentService.printStudentsSortedByYear(students);
        System.out.println("________________________________________________________________________");
    }
}
