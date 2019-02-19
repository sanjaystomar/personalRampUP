package org.personal.rampup.problemSolving;


import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CodingWars {


    // Complete the getCountOfPossibleTeams function below.
    static int getCountOfPossibleTeams(List<Integer> coders) {
        List<List<Integer>> teamList = new ArrayList<>();
        int teamCount = 0;
        for (int i = 0; i < coders.size(); i++) {
            List<Integer> team = new ArrayList<>();
            team.add(coders.get(i));

            for (int j = 0; j < coders.size(); j++) {
                int temp = 0;
                if (i < j) {
                    if (coders.get(i) < coders.get(j)) {
                        team.add(coders.get(j));
                        temp = coders.get(j);
                    } else {
                        if (temp > coders.get(j)) {
                            team.add(coders.get(j));
                        }
                    }
                } /*else if(i >j){
                    if (coders.get(i) > coders.get(j)) {
                        team.add(coders.get(j));
                        temp = coders.get(j);
                    } else {
                        if (temp < coders.get(j)) {
                            team.add(coders.get(j));
                        }
                    }
                }*/


                if (team.size() == 3) {
                    teamList.add(team);
                    System.out.println(team);
                    break;
                }
            }
        }
        System.out.println(teamList);
        return teamCount;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> coders = Arrays.asList(5, 5, 2, 3, 1, 4);
        int res = getCountOfPossibleTeams(coders);
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int codersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> codersTemp = new ArrayList<>();

        IntStream.range(0, codersCount).forEach(i -> {
            try {
                codersTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> coders = codersTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int res = getCountOfPossibleTeams(coders);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
*/
    }
}

