package ladder.view;

import java.util.Scanner;

public class Prompt {
    private static Scanner scanner = new Scanner(System.in);

    private Prompt() {
    }

    private static void clearInputStream() {
        scanner = new Scanner(System.in);
    }

    public static String askString(String questionMessage) {
        clearInputStream();

        Renderer.simplePrint(questionMessage);
        return scanner.nextLine();
    }

    public static int askInt(String questionMessage) {
        clearInputStream();

        Renderer.simplePrint(questionMessage);

        return scanner.nextInt();
    }
}