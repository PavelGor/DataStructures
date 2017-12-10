package com.gordeev.datastructures.oldTmp;

import java.util.Random;

public class EmployeeService {
    //fields
    private Employee[] employees;

    //constructors
    public EmployeeService(int size){
        generateEmployees(size);
    }

    //methods
    public int getSize() {
        return employees.length;
    }

    public void generateEmployees(int size){
        employees = new Employee[size];
        String[] namesMale = {"Mike", "Oland", "Nikita", "John", "Ivan", "Petro", "Hesus", "Damian", "Serge", "Anatolij"};
        String[] namesFemale = {"Olga", "Helga", "Mariya", "Katrine", "Marina", "Nataly"};
        Random random = new Random();

        for (int i=0; i< size; i++){
            int randomClass = random.nextInt(3);
            int age = 18 + random.nextInt(50);
            double salary = 1000 + random.nextInt(1000);
            int fixedBugs = random.nextInt(15);
            float rate = random.nextInt(15);
            int workedDays = random.nextInt(22);
            String name;
            char gender;
            if (random.nextBoolean()){
                gender = 'F';
                name = namesFemale[random.nextInt(namesFemale.length)];
            } else {
                gender = 'M';
                name = namesMale[random.nextInt(namesMale.length)];
            }

            if (randomClass == 0){
                Manager manager = new Manager();
                manager.setName(name);
                manager.setAge(age);
                manager.setSalary(salary);
                manager.setGender(gender);

                employees[i] = manager;

            } else {
                if (randomClass == 1){
                    Developer developer = new Developer();
                    developer.setName(name);
                    developer.setAge(age);
                    developer.setSalary(salary);
                    developer.setGender(gender);
                    developer.setFixedBugs(fixedBugs);

                    employees[i] = developer;

                } else {
                    Cleaner cleaner = new Cleaner();
                    cleaner.setName(name);
                    cleaner.setAge(age);
                    cleaner.setSalary(salary);
                    cleaner.setGender(gender);
                    cleaner.setRate(rate);
                    cleaner.setWorkedDays(workedDays);

                    employees[i] = cleaner;

                }
            }

        }


    }

    public void printEmployees(){
        for (int i=0; i< employees.length; i++){
            employees[i].printEmployee();
            System.out.println();
        }
    }

    public double calculateSalaryAndBonus(){
        double result = 0;
        for (int i=0; i<employees.length; i++){
            result += employees[i].calculatePayment();
        }
        return result;
    }
    public Employee getById(long id){
        for (int i=0; i<employees.length; i++){
            if (employees[i].getId() == id){
                return employees[i];
            }
        }
        return employees[0];
    }
    public Employee getByName(String name){
        for (int i=0; i<employees.length; i++){
            if (employees[i].getName() == name){
                return employees[i];
            }
        }
        return null;
    }
    public void sortByName(){
        for (int i=0; i<employees.length-1; i++) {
            for (int j=0; j<employees.length-1-i; j++) {
                if (employees[j].getName().compareTo(employees[j+1].getName())>0) {
                    Employee tmp = employees[j];
                    employees[j] = employees[j+1];
                    employees[j+1] = tmp;
                }
            }
        }
    }
    public void sortByNameAndSalary(){
        for (int i=0; i<employees.length-1; i++) {
            for (int j=0; j<employees.length-1-i; j++) {
                if (employees[j].getName().compareTo(employees[j+1].getName())>0) {
                    Employee tmp = employees[j];
                    employees[j] = employees[j+1];
                    employees[j+1] = tmp;
                }
            }
        }

        // O(N^2*LogN) - Sorry, but now I know only this way((
        for (int i = 0; i < employees.length-1; i++){
            int count = 0;
            while (employees[i].getName().equals(employees[i+1].getName())){
                count++;
            }
            int first = i - count;
            int last = i;
            if (count > 0){
                for (int j = first; j < last-1; j++){
                    for (int k = first; k < last-j; k++)
                    if (employees[k].getSalary() > employees[k+1].getSalary()){
                        Employee tmp = employees[k];
                        employees[k] = employees[k+1];
                        employees[k+1] = tmp;
                    }
                }
            }
        }


    }

    public void edit(Developer newDeveloper){
        Developer oldDeveloper = (Developer) getById(newDeveloper.getId());
        oldDeveloper.setFixedBugs(newDeveloper.getFixedBugs());

        edit(newDeveloper, oldDeveloper);
    }

    public void edit(Manager newManager){
        Manager oldManager = (Manager) getById(newManager.getId());

        edit(newManager, oldManager);
    }

    public void edit(Cleaner newCleaner){
        Cleaner oldCleaner = (Cleaner) getById(newCleaner.getId());
        oldCleaner.setRate(newCleaner.getRate());
        oldCleaner.setWorkedDays(newCleaner.getWorkedDays());

        edit(newCleaner, oldCleaner);
    }

    private Employee edit(Employee newEmployee, Employee oldEmployee){ //только для общего типа Employee(наследники). Узнать и использовать тип того сотрудника, которого копируем

        //Employee oldEmployee = getById(newEmployee.getId());

        oldEmployee.setName(newEmployee.getName());
        oldEmployee.setAge(newEmployee.getAge());
        oldEmployee.setGender(newEmployee.getGender());
        oldEmployee.setSalary(newEmployee.getSalary());

        return oldEmployee;
    }

}
