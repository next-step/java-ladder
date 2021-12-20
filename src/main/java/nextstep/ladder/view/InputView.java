package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import nextstep.ladder.LadderGame;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final String MESSAGE_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String MESSAGE_NAME_FOR_RESULT = "결과를 보고 싶은 사람은?";

    public static List<String> inputCommaSeparateString(String message) {
        System.out.println(message);
        String input = scanner.nextLine();

        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static int inputNumber(String message) {
        System.out.println(message);
        int number = scanner.nextInt();
        flush();
        return number;
    }

    public static String inputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private static void flush() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private static boolean reserved(String command) {
        return command.equalsIgnoreCase(LadderGame.QUIT_COMMAND) || command.equalsIgnoreCase(LadderGame.ALL_COMMAND);
    }

    public static List<String> inputNameOfPlayers() {
        List<String> names = inputCommaSeparateString(MESSAGE_PLAYER_NAMES);
        names.stream()
                .filter(InputView::reserved)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("ALL or QUIT is not allowed for name: " + name);
                });

        return names;
    }

    public static List<String> inputPrizeOfResult() {
        return inputCommaSeparateString(MESSAGE_RESULTS);
    }

    public static int inputHeight() {
        return inputNumber(MESSAGE_HEIGHT);
    }

    public static String inputNameForResult() {
        return inputString(MESSAGE_NAME_FOR_RESULT);
    }
}
