package com.gordeev.datastructures.oldTmp;

public class Employee {
    private static long nextId = 1;
    //fields
    private long id;
    private String name;
    private int age;
    private double salary;
    private char gender;

    public Employee(){
        this("",0,0,' ');
    }
    //constructor
    public Employee(String name, int age, double salary, char gender){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        id = nextId;
        nextId++;
    }


    //methods
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public static long getNextId() {
        return nextId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void printEmployee(){
        System.out.print(
                "Id = " + getId() + "; Name = " + getName() + "; Age = " + getAge() + "; Salary = " + getSalary() + "; Gender = " + getGender() + ";"
        );
    }
    public double calculatePayment(){
        return salary;
    }

}
