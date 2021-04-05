package ladder.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private final static String MESSAGE_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String MESSAGE_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String DELIMITER_COMMA = ",";
    private final static String MESSAGE_CHECK_NUMERIC = "높이 값은 정수여야 합니다.";
    private final static String NUMERIC_REGEX = "^[-]?[0-9]+$";
    private final static Pattern PATTERN_NUMERIC = Pattern.compile(NUMERIC_REGEX);
    private final static Scanner scanner = new Scanner(System.in);

    private InputView(){}

    private static int checkNumeric(String number) {
        number = number.trim();
        if (!PATTERN_NUMERIC.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NUMERIC);
        }
        return Integer.parseInt(number);
    }

    public static String[] enterPlayers(){
        System.out.println(MESSAGE_PLAYERS);
        String[] players = scanner.nextLine().split(DELIMITER_COMMA);
        players = Arrays.stream(players)
                .map(String::trim)
                .toArray(String[]::new);
        return players;
    }

    public static int enterHeight(){
        System.out.println();
        System.out.println(MESSAGE_HEIGHT);
        return checkNumeric(scanner.nextLine());
    }
}
