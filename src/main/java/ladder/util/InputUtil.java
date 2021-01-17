package ladder.util;

import java.util.Scanner;

public class InputUtil {
    private final static Scanner scanner = new Scanner(System.in);

    private InputUtil(){}

    public static String inputNames(){
        String names = input();
        return names;
    }

    public static String inputLadderHeight() {
        String names = input();
        return names;
    }

    private static String input() {
        return scanner.nextLine().trim();
    }
}
