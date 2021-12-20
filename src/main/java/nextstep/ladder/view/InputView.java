package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import nextstep.ladder.LadderGame;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

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

    public static List<String> inputNameOfPlayers() {
        List<String> names = inputCommaSeparateString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        names.stream()
                .filter(name -> name.equalsIgnoreCase(LadderGame.QUIT_COMMAND) || name.equalsIgnoreCase(LadderGame.ALL_COMMAND))
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("ALL or QUIT is not allowed for name: " + name);
                });

        return names;
    }

    public static List<String> inputPrizeOfResult() {
        return inputCommaSeparateString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static int inputHeight() {
        return inputNumber("최대 사다리 높이는 몇 개인가요?");
    }

    public static String inputNameForResult() {
        return inputString("결과를 보고 싶은 사람은?");
    }
}
