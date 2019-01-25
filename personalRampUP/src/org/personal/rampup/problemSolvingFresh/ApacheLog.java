package org.personal.rampup.problemSolvingFresh;

/**
 * Given a log file, return IP address(es) which accesses the site most often.
 */
public class ApacheLog {

    public static String findTopIpaddress(String[] lines) {
        // Your code goes here
        return "10.0.0.1";
    }

    public static boolean doTestsPass() {
        return false;
    }

    public static void main(String[] args) {

        String lines[] = new String[]{
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132"};
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");
        }
    }
}
