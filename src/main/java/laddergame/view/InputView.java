package laddergame.view;

import laddergame.domain.EndPoints;
import laddergame.domain.Level;
import laddergame.domain.Participants;
import laddergame.util.StringUtils;
import laddergame.validator.InputLineValidator;
import laddergame.validator.Validatable;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";

    private static final Validatable<String> validator = new InputLineValidator();
    private static final Scanner scanner = new Scanner(System.in);

    public static Participants getParticipants() {
        showParticipantsInputMessage();
        return new Participants(getInputLine().split(DELIMITER));
    }

    private static void showParticipantsInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static EndPoints getRewards() {
        showRewardsInputMessage();
        return new EndPoints(getInputLine().split(DELIMITER));
    }

    private static void showRewardsInputMessage() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static Level getLevel() {
        showGameLevelInputMessage();
        return Level.getLevel(getInputLine());
    }

    private static void showGameLevelInputMessage() {
        System.out.println("\n실행할 사다리의 난이도는?");
    }

    public static String getRewardResultKey() {
        showResultNameInputMessage();
        return getInputLine();
    }

    private static void showResultNameInputMessage() {
        System.out.println("\n결과를 보고 싶은 사람은?");
    }

    private static String getInputLine() {
        String inputLine = scanner.nextLine();
        validator.validate(inputLine);
        return StringUtils.removeWhitespace(inputLine);
    }
}