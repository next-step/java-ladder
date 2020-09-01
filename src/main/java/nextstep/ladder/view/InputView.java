package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String PRINT_GAME_START = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
    private static final String PRINT_LADDER_HEIGHT_NUMBER = "최대 사다리 높이는 몇 개인가요?";

    public static String inputGameUser(Scanner scanner) {
        System.out.println(PRINT_GAME_START);
        return scanner.nextLine();
    }

    public static int inputLadderHeight(Scanner scanner) {
        System.out.println(PRINT_LADDER_HEIGHT_NUMBER);
        return scanner.nextInt();
    }

}
