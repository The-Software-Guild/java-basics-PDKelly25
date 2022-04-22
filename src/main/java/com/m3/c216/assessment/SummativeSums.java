package com.m3.c216.assessment;

public class SummativeSums {
    public static int sum(int[] array){
        int sum=0;
        for (int x: array){
            sum+=x;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[] {1, 90, -33, -55, 67, -16, 28, -55, 15}));
        System.out.println(sum(new int[] { 999, -60, -77, 14, 160, 301 }));
        System.out.println(sum(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                140, 150, 160, 170, 180, 190, 200, -99 } ));
    }
}
