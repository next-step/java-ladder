package ladder.view;

import utils.StringSplitter;

import java.util.List;
import java.util.Scanner;

import static ladder.app.LadderApp.ALL;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return StringSplitter.split(inputLine(), DELIMITER);
    }

    public static List<String> inputRewardNames() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return StringSplitter.split(inputLine(), DELIMITER);
    }

    public static int inputLadderHeights() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputInt();
    }

    public static String inputPlayerName() {
        System.out.printf("결과를 보고 싶은 사람은?(전체를 볼 경우 %s 입력)%n", ALL);
        return inputLine().trim();
    }

    private static String inputLine() {
        return SCANNER.nextLine();
    }

    private static int inputInt() {
        int input = SCANNER.nextInt();
        flushNewLine();
        return input;
    }

    private static void flushNewLine() {
        SCANNER.nextLine();
    }
}
