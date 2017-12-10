package com.gordeev.datastructures.oldTmp;

import com.gordeev.datastructures.list.ArrayList;

import java.io.IOException;

public class OldMainTest {
    public static void main (String[] args) {
        //testList();
        //testMostFrequentChar();
        //testCheckDuplicates();
        //testEmployee();

        /*
        FileManager fileManager = new FileManager();
        try {
            System.out.println(fileManager.calculateFiles("C:\\Users\\PM\\Desktop\\WorkTMP2"));
            System.out.println(fileManager.calculateDirs("C:\\Users\\PM\\Desktop\\WorkTMP2"));
        //    System.out.println(fileManager.copy("C:\\Users\\PM\\Desktop\\WorkTMP2\\12", "C:\\Users\\PM\\Desktop\\WorkTMP2\\22"));
        //    System.out.println(fileManager.move("C:\\Users\\PM\\Desktop\\WorkTMP2\\12", "C:\\Users\\PM\\Desktop\\WorkTMP2\\22"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        NumberConverter numberConverter = new NumberConverter();
        System.out.println(numberConverter.toString(12345));

    }

    // дополнительно: самый часто встречающийся символ в строке [a...z], O(N*M)
    public static char mostFrequentChar(String value){
        int[] count = new int[26];

        for (char letter: value.toCharArray()) {
            count[letter-97]++;
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= max){
                max = count[i];
                index = i;
            }
        }
        if (max > 0){
            return (char) (index + 97);
        } else {
            return 0; //что втаком случае обычно выводят по умолчанию?
        }

    }

    public static void testMostFrequentChar(){
        // mostFrequentChar
        System.out.println();
        String string = "qqwertyucccccccccbbb";
        System.out.println("mostFrequentChar of " + string + " is " + mostFrequentChar(string));

    }

    public static boolean checkDuplicates(byte[] array){
        int[] count = new int[256];

        for (int i=0; i<array.length; i++) {
            count[i+127]++;
        }
        for (int i=0; i<255; i++) {
            if (count[i]>0){
                return true;
            }
        }
        return false;

    }

    public static void testCheckDuplicates(){
        // checkDuplicates
        System.out.println();
        byte[] byteArray = {9,8,9,6,5,4,3,2,1};
        System.out.println("Array has duplicates - " + checkDuplicates(byteArray));

    }

    public static void testEmployee(){
        Developer developer = new Developer("Mike",19,40,'M', 25);
        Employee employee = new Employee("Mike",19,40,'M');


        EmployeeService employeeService = new EmployeeService(10);
        employeeService.printEmployees();
        System.out.println();

        System.out.println(employeeService.calculateSalaryAndBonus());
        System.out.println(employeeService.getById(2).toString());
        System.out.println(employeeService.getByName("Mike").toString());

        employeeService.sortByName();
        employeeService.printEmployees();
        System.out.println();

        employeeService.sortByNameAndSalary();
        employeeService.printEmployees();
        System.out.println();

        System.out.println(mostFrequentChar("cccabbbcdcd"));

    }

    public static void testList(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");
        arrayList.add("G");
        arrayList.add("H");

        System.out.println(arrayList.toString());
        System.out.println("size = " + arrayList.size()); //8
        System.out.println("get(2) = " + arrayList.get(2)); //C
        System.out.println("remove(3) = " + arrayList.remove(3)); //D
        System.out.println("size = " + arrayList.size()); //7
        System.out.println(arrayList.toString());
        arrayList.add("I");
        System.out.println("add(\"I\") : " + "size = " + arrayList.size()); //8
        System.out.println(arrayList.toString());
        arrayList.add("K",5);
        arrayList.set("L",4);
        System.out.println("contains(\"B\") = " + arrayList.contains("B"));
        System.out.println("add(\"K\",5) + set(\"L\",4)");
        System.out.println("size = " + arrayList.size()); //9
        System.out.println(arrayList.toString());
        System.out.println("isEmpty = " + arrayList.isEmpty());
        arrayList.clear();
        System.out.println("clear() + isEmpty = " + arrayList.isEmpty());
    }
}
