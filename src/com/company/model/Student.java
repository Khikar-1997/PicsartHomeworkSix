package com.company.model;

public class Student {
    //region Properties
    private String firstName;
    private String lastName;
    private int year;
    private String gender;
    private double mark;
    //endregion

    //region Constructors
    public Student() {
    }

    public Student(String firstName, String lastName, int year, String gender, double mark) {
        if (firstName.length() > 0) {
            this.firstName = firstName;
        } else {
            System.out.println("The 'first name' value is not valid,please try again");
        }

        if (lastName.length() > 0) {
            this.lastName = lastName;
        } else {
            System.out.println("The 'last name' value is not valid,please try again");
        }

        if (year >= 1900 && year <= 2020) {
            this.year = year;
        } else {
            System.out.println("The 'year' value is not valid,please try again");
        }

        if (gender.length() > 0) {
            this.gender = gender;
        } else {
            System.out.println("The 'gender' value is not valid,please try again");
        }

        if (mark > 0) {
            this.mark = mark;
        } else {
            System.out.println("The 'mark' value is not valid,please try again");
        }
    }
    //endregion

    //region Getters and Setters methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 0) {
            this.firstName = firstName;
        } else {
            System.out.println("The 'first name' value is not valid,please try again");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 0) {
            this.lastName = lastName;
        } else {
            System.out.println("The 'last name' value is not valid,please try again");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1900 && year <= 2020) {
            this.year = year;
        } else {
            System.out.println("The 'year' value is not valid,please try again");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.length() > 0) {
            this.gender = gender;
        } else {
            System.out.println("The 'gender' value is not valid,please try again");
        }
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (mark > 0) {
            this.mark = mark;
        } else {
            System.out.println("The 'mark' value is not valid,please try again");
        }
    }
    //endregion

    //region To String method
    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                ", gender='" + gender + '\'' +
                ", mark=" + mark;
    }
    //endregion
}
