package view;

import utils.Parser;

import java.util.List;
import java.util.Scanner;

import static utils.Parser.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PARTICIPANT_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_INPUT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";

    public static List<String> inputParticipantNames() {
        System.out.println(PARTICIPANT_NAMES_INPUT_MESSAGE);
        return split(scanner.nextLine(), DELIMITER);
    }

    public static int inputMaxLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT_INPUT_MESSAGE);
        return toInt(scanner.nextLine());
    }
}
