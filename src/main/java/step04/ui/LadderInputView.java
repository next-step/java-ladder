package step04.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PARTICIPANTS_PHRASE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_PHRASE = "최대 사다리 높이는 몇 개인가요?";
    private static final String REWARD_PHRASE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String RESULT_USER_PHRASE = "결과를 보고 싶은 사람은?";
    private static final String INPUT_DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final String BLANK_STRING = "";

    public static void printParticipantsPhrase() {
        System.out.println(PARTICIPANTS_PHRASE);
    }

    public static List<String> getUserInputs() {
        String[] userNames = scanner.nextLine()
                .replaceAll(WHITE_SPACE_REGEX, BLANK_STRING)
                .split(INPUT_DELIMITER);

        return Arrays.stream(userNames)
                .collect(Collectors.toList());
    }

    public static void printRewardPhrase() {
        System.out.println(NEW_LINE + REWARD_PHRASE);
    }

    public static void printLadderHeightPhrase() {
        System.out.println(NEW_LINE + LADDER_HEIGHT_PHRASE);
    }

    public static int getLadderHeight() {
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public static void printResultUserPhrase() {
        System.out.println(NEW_LINE + RESULT_USER_PHRASE);
    }

    public static String getResultUserName() {
        return scanner.nextLine();
    }
}
