package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String NEWLINE = System.lineSeparator();
    public static final String COMMA_DELIMITER = "\\s*,\\s*";
    public static final String PLAYER_NAMES_PROMPT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String PRIZES_PROMPT = NEWLINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String HEIGHT_PROMPT = NEWLINE + "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> playerNames() {
        System.out.println(PLAYER_NAMES_PROMPT);
        String line = scanner.nextLine();
        return Arrays.asList(line.split(COMMA_DELIMITER));
    }

    public static List<String> prizes() {
        System.out.println(PRIZES_PROMPT);
        String line = scanner.nextLine();
        return Arrays.asList(line.split(COMMA_DELIMITER));
    }

    public static int ladderHeight() {
        System.out.println(HEIGHT_PROMPT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String resultForName() {
        System.out.println(NEWLINE + "결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

}
