package ladder.view;

import ladder.view.output.LadderGameCreateOutputView;
import ladder.view.output.LadderGameResultOutputView;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static String PERSON_NAME_SEPARATOR = ",";

    public static String[] personNameInput() {
        LadderGameCreateOutputView.inputPeople();
        return splitPersonName(scanner.nextLine());
    }

    public static String[] splitPersonName(String text) {
        return text.split(PERSON_NAME_SEPARATOR);
    }

    public static int ladderHeight() {
        LadderGameCreateOutputView.inputLadderHeight();
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputResultPersonName() {
        LadderGameResultOutputView.inputResultPersonName();
        return scanner.nextLine().trim();
    }
}
