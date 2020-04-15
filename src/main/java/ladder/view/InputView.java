package ladder.view;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String REQUEST_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_PRIZE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String REQUEST_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_WINNER = "결과를 보고 싶은 사람은?";
    private static final String COMMA = ",";

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream CONSOLE = System.out;

    private InputView() {
    }

    public static List<String> requestPlayerNames() {
        CONSOLE.println(REQUEST_NAME);
        return parseInputString();
    }

    public static List<String> requestPrizes() {
        CONSOLE.println(REQUEST_PRIZE);
        return parseInputString();
    }

    public static int requestHeight() {
        CONSOLE.println(REQUEST_HEIGHT);
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidInputNumberException();
        }
    }

    private static List<String> parseInputString() {
        String inputValue = SCANNER.nextLine();
        return stream(inputValue.split(COMMA))
                .map(String::trim)
                .collect(toList());
    }

    public static String requestWinners() {
        CONSOLE.println(REQUEST_WINNER);
        return SCANNER.next();
    }
}
