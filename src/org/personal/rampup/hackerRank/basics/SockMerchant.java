package org.personal.rampup.hackerRank.basics;

import java.io.*;
import java.util.*;

public class SockMerchant {

    // Complete the calculateSockPairs function below.
    static int calculateSockPairs(int n, int[] ar) {

        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int x : ar) {
            if (pairMap.get(x) != null) {
                pairMap.put(x, pairMap.get(x) + 1);
            } else {
                pairMap.put(x, 1);
            }
        }
        int pairs = 0;
        for (Map.Entry<Integer, Integer>  entry : pairMap.entrySet()){
            pairs += entry.getValue()/ 2;
        }


        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      /*  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }*/

      int n = 9;
      int [] ar = {10,20,20,10,10,30,50,10,20};
        int result = calculateSockPairs(n, ar);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

