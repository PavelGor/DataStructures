package com.gordeev.datastructures.oldTmp;

public class Cleaner extends Employee {
    //fields
    private float rate;
    private int workedDays;

    //constructors
    public Cleaner(String name, int age, double salary, char gender, float rate, int workedDays){
        super(name, age, salary, gender);
        this.rate = rate;
        this.workedDays = workedDays;
    }

    public Cleaner(){

    }
    //methods

    public int getWorkedDays() {
        return workedDays;
    }

    public float getRate() {
        return rate;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
    public void printEmployee(){
        super.printEmployee();
        System.out.print(" Rate = " + getRate() + "; WorkedDays = " + getWorkedDays());
    }

    @Override
    public double calculatePayment() {
        return super.calculatePayment() + rate * workedDays;
    }
}
