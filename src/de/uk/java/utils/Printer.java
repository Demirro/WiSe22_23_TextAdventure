package de.uk.java.utils;

public class Printer {
    public static void print(String string, int delayInMs) {
        for (char c : string.toCharArray()) {
            System.out.print(c);
            if (c != ' ') {
                try {
                    Thread.sleep(delayInMs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void print(String string) {
        print(string, 0);
    }

    public static void println(String string, int delayInMs) {
        print(string, delayInMs);
        System.out.println();
    }

    public static void println(String string) {
        println(string, 0);
    }

    public static void clear() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

}
