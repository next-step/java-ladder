package ladder.view;

import ladder.view.output.LadderGameCreateOutputView;
import ladder.view.output.LadderGameResultOutputView;

import java.util.Scanner;

import static ladder.util.LadderConst.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] personNameInput() {
        LadderGameCreateOutputView.inputPeople();
        return splitPersonName(scanner.nextLine());
    }

    public static String[] splitPersonName(String text) {
        return text.split(PERSON_NAME_SEPARATOR);
    }

    public static String[] splitResult() {
        LadderGameCreateOutputView.inputPlayResult();
        return scanner.nextLine().split(INPUT_RESULT_SEPARATOR);
    }

    public static int ladderHeight() {
        LadderGameCreateOutputView.inputLadderHeight();
        return Integer.parseInt(scanner.nextLine());
    }

    public static String[] inputResultPersonName() {
        LadderGameResultOutputView.inputResultPersonName();
        String text = scanner.nextLine().trim();
        if (text.contains(PERSON_NAME_SEPARATOR)) {
            return splitPersonName(text);
        }
        return new String[]{text};
    }
}
