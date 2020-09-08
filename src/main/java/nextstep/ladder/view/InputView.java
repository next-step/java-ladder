package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String PRINT_GAME_START = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
    private static final String PRINT_LADDER_HEIGHT_NUMBER = "최대 사다리 높이는 몇 개인가요?";
    private static final String PRINT_INPUT_LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PRINT_GAME_RESULT = "결과를 보고 싶은 사람은?";

    public static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputGameUser() {
        System.out.println(PRINT_GAME_START);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(PRINT_LADDER_HEIGHT_NUMBER);
        return scanner.nextInt();
    }

    public static String inputLadderResult() {
        System.out.println(PRINT_INPUT_LADDER_RESULT);
        return scanner.nextLine();
    }

    public static String inputGameResult() {
        System.out.println(PRINT_GAME_RESULT);
        return scanner.nextLine();
    }

}
