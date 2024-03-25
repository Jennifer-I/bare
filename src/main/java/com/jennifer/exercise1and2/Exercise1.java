package com.jennifer.exercise1and2;

import java.util.Arrays;

public class Exercise1 {
    //    Write a simple Java >= 7 program that returns the smallest non occurring integer in a given Array.

    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};

        System.out.println("Smallest non-occurring integer in array1: " + findSmallestNonOccurring(array1));
        System.out.println("Smallest non-occurring integer in array2: " + findSmallestNonOccurring(array2));
    }

    public static int findSmallestNonOccurring(int[] array) {
        return Arrays.stream(array)
                .filter(num -> num > 0)
                .distinct()
                .sorted()
                .reduce(1, (acc, num) -> {
                    if (num == acc) {
                        return acc + 1;
                    } else {
                        return acc;
                    }
                });
    }
}



