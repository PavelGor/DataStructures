package com.gordeev.datastructures.oldTmp;

import java.util.Arrays;

public class HomeWorkOneReview {
    /*public static void main(String[] args) {

        char[] charArrayA = {'1','b','c','d','e','f','g','h'};
        char[] charArrayB = {'b','c','d'};
        int[] intArrayA = {9,8,7,6,5,4,3,2,12};
        int[] intArrayB = {9,8,7,6,5,4,3,2,11};
        byte[] byteArrayA = {9,8,9,6,5,4,3,2,1};

        //1) принимает массив чаров, выводит его на экран
        System.out.println("Task1:");
        print(charArrayA);
        //2) принимает массив интов, возвращает массив чаров, каждый символ в позиции массива соответствует коду символа передаваемого инта
        System.out.println("Task2:");
        toCharArray(intArrayA);
        //3) приминает 2 инта, а и б, возвращает большее их этих 2х чисел
        System.out.println("Task3:");
        System.out.println(max(3,18));
        //4) принимает 3 инта, возвращает большее из них
        System.out.println("Task4:");
        System.out.println(max(3,18,15));
        //5) приминает 5 интов, возвращает большее из них
        System.out.println("Task5:");
        System.out.println(max(3,18,15,22,-4));
        //6) принимает массив чаров, возвращает строку состоящую из символов массива
        System.out.println("Task6:");
        System.out.println(toString(charArrayA));
        //8) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым, начиная с начала массива. Если значения в массиве нет возвращает -1
        System.out.println("Task8:");
        System.out.println(indexOf(intArrayA,12));
        //9) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым, начиная с конца массива. Если значения в массиве нет возвращает -1
        System.out.println("Task9:");
        System.out.println(lastIndexOf(intArrayA,5));
        //метод принимает инт, и возвращает факториал от заданого инта
        // - насколько большие числа? может увеличить тип возвращаемого значения?
        System.out.println("Task10:");
        System.out.println(factorialOne(5));
        System.out.println(factorialTwo(4));
        //11) принимает инт год, и возвращает тру если год высокосный
        System.out.println("Task11:");
        System.out.println(isLeapYear(1900));
        //12) приминает массив интов и число, выводит на екран только елементы массива которые кратны этому числу
        System.out.println("Task12:");
        printMultiple(intArrayA,2);
        //13) метод принимает массив интов сортирует его по возрастанию
        System.out.println("Task13:");
        sort(intArrayA);
        System.out.println(Arrays.toString(intArrayA));
        //14) принимает массив байт, если в массиве есть повторяющиеся елементы, возвращает тру
        System.out.println("Task14:");
        System.out.println(checkDuplicates(byteArrayA));
        //15) принимает два массива интов одинаковых по длинне, возращает массив интов который состоит из перемноженных елементов входящих массивов
        System.out.println("Task15:");
        for (int element : multiplyArrays(intArrayA,intArrayB)) {
            System.out.print(element+" ");
        }
        System.out.println();
        //16) принимает два массива интов, возвращает массив из елементов которые не совпадают в массивах
        System.out.println("Task16:");
        for (int element : printUniqueElement(intArrayA,intArrayB)) {
            System.out.print(element+" ");
        }
        System.out.println();
        //17) принимает масив интов, возвращает его же но в реверсном порядке
        System.out.println("Task17:");
        for (int element : reverse(intArrayA)) {
            System.out.print(element+" ");
        }
        System.out.println();
        //18
        System.out.println("Task18:");
        for (int element : generator(10, 100, 20)) {
            System.out.print(element+" ");
        }
        System.out.println();

        //19) принимает 2 массива чаров, проверяет есть ли в 1 массиве, такая же последовательность символов которую представляет собой второй массив. Возвращает булеан
        System.out.println("Task19:");
        System.out.print(contains(charArrayA, charArrayB));

    }*/

    //1) принимает массив чаров, выводит его на экран
    public static void print(char[] array){
        for(char element:array){
            System.out.print(element);
        }
        System.out.println();
    }

    //2) принимает массив интов, возвращает массив чаров, каждый символ в позиции массива соответствует коду символа передаваемого инта
    public static char[] toCharArray(int[] array){
        char[] charArray = new char[array.length];
        for (int i=0; i<array.length; i++) {
            charArray[i]=(char)array[i];
        }
        return charArray;
    }

    //3) приминает 2 инта, а и б, возвращает большее их этих 2х чисел
    public static int max(int a, int b){
        return a>b ? a : b;

    }
    //4) принимает 3 инта, возвращает большее из них
    public static int max(int a, int b, int c){
        return max(max(a,b),c);

    }
    //5) приминает 5 интов, возвращает большее из них
    public static int max(int a, int b, int c, int d, int e){
        return max(max(a,b),max(c,d,e));
    }

    //6) принимает массив чаров, возвращает строку состоящую из символов массива
    public static String toString(char[] array){
        String str = "";
        for (char element : array) {
            str += element;
        }
        return str;
    }
    //8) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым, начиная с начала массива. Если значения в массиве нет возвращает -1
    public static int indexOf(int[] array, int number){
        for (int i=0; i<array.length; i++) {
            if (number==array[i]) {
                return i;
            }
        }
        return -1; //не учтен вариант если есть несколько значений в массиве
    }
    //9) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым, начиная с конца массива. Если значения в массиве нет возвращает -1
    public static int lastIndexOf(int[] array, int number){
        for (int i=array.length-1; i>0; i--) {
            if (number==array[i]) {
                return i;
            }
        }
        return -1; //не учтен вариант если есть несколько значений в массиве
    }
    //10) метод принимает инт, и возвращает факториал от заданого инта
    public static int factorialOne(int fact){
        int result = 1;
        for (int i=1; i<=fact; i++) {
            result *=i;
        }
        return result;
    }

    public static int factorialTwo(int fact){
        if (fact == 0) {
            return 1;
        }
        return fact * factorialTwo(fact-1);
    }
    //11) принимает инт год, и возвращает тру если год высокосный
    public static boolean isLeapYear(int year){
        if (year%400==0) {
            return true;
        } else {
            if (year%4==0&&year%100!=0) {
                return true;
            } else {
                return false;
            }
        }
    }
    //12) приминает массив интов и число, выводит на екран только елементы массива которые кратны этому числу
    public static void printMultiple(int[] array, int number){
        for (int i=0; i<array.length; i++) {
            if (array[i] % number == 0) {
                System.out.print(array[i]+" ");
            }
        }
        System.out.println();
    }

    //13) метод принимает массив интов сортирует его по возрастанию
    public static void sort(int[] array){
        for (int i=0; i<array.length-1; i++) {
            for (int j=0; j<array.length-1-i; j++) {
                if (array[j]>array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    //14) принимает массив байт, если в массиве есть повторяющиеся елементы, возвращает тру
    //какая алгоритмическая сложность метода? O(N^2)
    public static boolean checkDuplicates(byte[] array){
        /*for (int i=0; i<array.length-1; i++) {
            for (int j=1+i; j<array.length-1; j++) {
                if (array[i]==array[j]) {
                    return true;
                }
            }
        }
        return false;
        */
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
    //15) принимает два массива интов одинаковых по длинне, возращает массив интов который состоит из перемноженных елементов входящих массивов
    public static int[] multiplyArrays(int[] arrayOne, int[] arrayTwo){
        int[] resultArray = new int[arrayOne.length];
        for (int i=0; i<arrayOne.length; i++) {
            resultArray[i]=arrayOne[i]*arrayTwo[i];
        }
        return resultArray;
    }

    //16) принимает два массива интов, возвращает массив из елементов которые не совпадают в массивах
    //какая алгоритмическая сложность метода? O(N*M)
    public static int[] printUniqueElement(int[] arrayOne, int[] arrayTwo){
        int count = 0;
        //подсчет длины массива неповторяющихся
        for (int i=0; i<arrayOne.length; i++) {
            for (int j=0; j<arrayTwo.length; j++) {
                if (arrayOne[i]==arrayTwo[j]) {
                    count++;
                }
            }
        }
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayOne.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) {
                    count++;
                }
            }
        }
        //заполнение массива неповторяющихся

        int[] resultArray = new int[arrayOne.length+arrayTwo.length-count];
        count = 0;
        int iResult = 0;
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                resultArray[iResult] = arrayOne[i];
                iResult++;
            }
            count = 0;

        }
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayOne.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                resultArray[iResult] = arrayTwo[i];
                iResult++;
            }
            count = 0;

        }


        return resultArray;
    }
    //17) принимает масив интов, возвращает его же но в реверсном порядке
    public static int[] reverse(int[] array){
        int[] resultArray = new int[array.length];
        for (int i=0; i<array.length; i++) {
            resultArray[i] = array[array.length - 1 - i];
        }
        return resultArray;
    }

    /*18) принимает 3 инта:
        - размер выходного массива
        - нижняя граница
        - верхняя граница
        возвращает массив интов заданой длинный, который содержит случайные числа от нижней границы до верхней границы"*/
    public static int[] generator(int size, int upperLimit, int lowerLimit){

        int[] result = new int[size];

        for (int i=0; i<size; i++){
            int tmp = (int) (Math.random()*upperLimit);
            while (tmp<lowerLimit){
                tmp = (int) (Math.random()*upperLimit);
            }
            result[i] = tmp;
        }
        return result;
    }
    //19) принимает 2 массива чаров, проверяет есть ли в 1 массиве, такая же последовательность символов которую представляет собой второй массив. Возвращает булеан
    public static boolean contains(char[] array, char[] subArray){

        for (int i=0; i<array.length; i++) {
            int count = 0;
            if (subArray[0] == array[i]){
                for (int j = 0; j < subArray.length; j++){
                    if (subArray[j] == array[i+j]){
                        count++;
                    } else {
                        break;
                    }
                    if(count == subArray.length){
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
