package ladder.view;

import ladder.constant.Question;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String[] participantsScan() {
        System.out.println(Question.PARTICIPANTS.getQuestion());
        return scanner.nextLine().split(",");
    }

    public static int heightScan() {
        System.out.println(Question.HEIGHT.getQuestion());
        return scanner.nextInt();
    }
}
