package org.personal.rampup.problemSolving;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NineBulbProblem {

    public static void main(String[] args) {
        int[] initialBulbArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(findOnBulbs(initialBulbArray));

    }

    public static String findOnBulbs(int[] initialBulbArray) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i <= initialBulbArray.length; i++) {
            for (int j = 1; j * i < initialBulbArray.length; j++) {
                initialBulbArray[i * j] = initialBulbArray[i * j] == 0 ? 1 : 0;
            }
        }
        IntStream.range(1, initialBulbArray.length).filter(e -> initialBulbArray[e] == 1).forEach(e -> sb.append(e).append(" "));
        /*for(int i=0; i< initialBulbArray.length; i++){
            if(initialBulbArray[i] ==1)  sb.append(i).append( " ");
        }*/
        return sb.toString();
    }
}
