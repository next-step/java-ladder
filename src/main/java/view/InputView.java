package view;

import constant.Question;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public abstract class InputView {

    private InputView() {
    }

    public static int IntegerQuestion(final String question) {
        final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));
        printQuestion(question);
        return scanner.nextInt();
    }

    public static String StringQuestion(final String question) {
        final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));
        printQuestion(question);
        return scanner.nextLine();
    }

    public static String getInputPlayer() {
        System.out.println();
        System.out.println(Question.WHO_WANTS_TO_SEE_THE_RESULTS);
        final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));
        return scanner.nextLine();
    }

    private static void printQuestion(final String question) {
        System.out.println(question);
    }

}
