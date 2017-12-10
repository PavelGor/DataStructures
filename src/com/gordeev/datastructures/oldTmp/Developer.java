package com.gordeev.datastructures.oldTmp;

import java.util.Random;

public class Developer extends Employee{
    //fields
    private int fixedBugs;

    //constructors
    public Developer(String name, int age, double salary, char gender, int fixedBugs){
        super(name, age, salary, gender);
        this.fixedBugs = fixedBugs;
    }

    public Developer(){

    }

    //methods

    public int getFixedBugs() {
        return fixedBugs;
    }

    public void setFixedBugs(int fixedBugs) {
        this.fixedBugs = fixedBugs;
    }
    public void printEmployee(){
        super.printEmployee();
        System.out.print(" FixedBugs = " + getFixedBugs());
    }

    @Override
    public double calculatePayment() {
        Random random = new Random();
        return (super.calculatePayment() + fixedBugs * 10) * (random.nextBoolean()?2:0);
    }
}
