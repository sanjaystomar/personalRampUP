package org.personal.rampup.random;

/**
 * 9466
 * *** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message transform method call failed at JPLISAgent.c line: 844
 * *** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message transform method call failed at JPLISAgent.c line: 844
 *
 * 9879
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at sun.nio.cs.UTF_8$Encoder.encodeLoop(UTF_8.java:691)
 * 	at java.nio.charset.CharsetEncoder.encode(CharsetEncoder.java:579)
 * 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:271)
 * 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
 * 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
 * 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
 * 	at java.io.PrintStream.write(PrintStream.java:526)
 * 	at java.io.PrintStream.print(PrintStream.java:597)
 * 	at java.io.PrintStream.println(PrintStream.java:736)
 * 	at org.personal.rampup.random.StackOverFlowDepth.run(StackOverFlowDepth.java:11)
 *
 *
 * 	9865
 */
public class StackOverFlowDepth {
    static int count=0;

    public static void main(String[] args) {
           run();
    }

    public static void run() {
        System.out.println(count++);
        run();
    }
}
