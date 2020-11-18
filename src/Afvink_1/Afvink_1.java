package com.adeepdrive.swap.numbers;

public class Afvink_1 {

    public static void main(String[] args) {
        int values[] = {10, 25, 60, 63, 36, 26, 42, 7, 18, 30};
        int length = values.length;
        System.out.println("Before sorting: ");
        for (int value : values) {
            System.out.print(" " + value);
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (values[i] < values[j]) {
                    int temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
//            System.out.print("For outer loop i value : "+i+" : ");
            for (int value : values) {
//                System.out.print(" " + value);
            }
//            System.out.println();
        }
        System.out.println("After sorting in Ascending Order");
        for (int value : values) {
            System.out.print(" " + value);
        }
    }
}