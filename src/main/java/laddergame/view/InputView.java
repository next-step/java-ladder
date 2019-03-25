package laddergame.view;

import laddergame.domain.Participants;
import laddergame.util.StringUtils;
import laddergame.validator.InputLineValidator;
import laddergame.validator.Validatable;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private final static Validatable<String> validator = new InputLineValidator();

    public static Participants getParticipants() {
        showParticipantsInputMessage();
        return new Participants(getInputLine());
    }

    private static void showParticipantsInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static Integer getMaximumHeight() {
        showMaximumLadderHeightInputMessage();
        return Integer.parseInt(getInputLine());
    }

    private static void showMaximumLadderHeightInputMessage() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    }

    public static String getInputLine() {
        String inputLine = scanner.nextLine();
        validator.validate(inputLine);
        return StringUtils.removeWhitespace(inputLine);
    }
}