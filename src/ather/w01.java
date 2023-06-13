package ather;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class w01 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int ran1 = random.nextInt(10);
        int ran2 = random.nextInt(10);
        int ran3 = random.nextInt(10);
        int[] randomArr = new int[3];

        while (ran1 == ran2 || ran1 == ran3 || ran2 == ran3){
            ran2 = random.nextInt(10);
            ran3 = random.nextInt(10);
        }

        randomArr[0] = ran1;
        randomArr[1] = ran2;
        randomArr[2] = ran3;



    }
}
