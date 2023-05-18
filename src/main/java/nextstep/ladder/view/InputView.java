package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PLAYERS_NAME_TEXT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_TEXT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_TEXT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static String inputPlayers() {
        System.out.println(INPUT_PLAYERS_NAME_TEXT);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_TEXT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputResult() {
        System.out.println(INPUT_RESULT_TEXT);
        return scanner.nextLine();
    }

}
