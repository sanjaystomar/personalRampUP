package org.personal.rampup.problemSolving;

import java.util.*;

public class ApacheLog {
    public static void main(String[] args) {
        runTests();
    }

    public static boolean runTests() {
        String [] lines = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.2.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.2.2 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.2.2 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.2.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10 /Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};
        System.out.println(mostOftenUsedIp(lines));
        return false;

    }

    public static String mostOftenUsedIp(String[] args) {
        Map<String, Integer> occurenceMap = new HashMap<>();
        for (String s : args) {
            String[] tempArray = s.split(" - ");
            int count = 1;
            if (occurenceMap.get(tempArray[0]) != null) {
                count = occurenceMap.get(tempArray[0]);
                occurenceMap.put(tempArray[0], count + 1);
            } else {
                occurenceMap.put(tempArray[0], count);
            }
        }
        StringJoiner sj = new StringJoiner(",");
        final Integer max = occurenceMap.entrySet().stream().max((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1).get()
                .getValue();
        occurenceMap.entrySet().stream().filter(p -> max == p.getValue()).sorted((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1).forEach(p -> sj.add(p.getKey()));
        return sj.toString();




       /*
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(occurenceMap.entrySet());
        Map<String, Integer> sortedByValueMap = new LinkedHashMap<>();
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(sortedByValueMap.entrySet().stream().max((e1,e2)-> e1.getValue()));
//        sortedByValueMap.entrySet().stream().filter()
        return entryList.get(entryList.size() - 1).getKey() + "Value: " + entryList.get(entryList.size() - 1).getValue();*/
    }
}
