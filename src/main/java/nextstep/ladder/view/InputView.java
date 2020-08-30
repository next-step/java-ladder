package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String PRINT_GAME_START = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";

    public static String setGameUser(Scanner scanner) {
        System.out.println(PRINT_GAME_START);
        return scanner.nextLine();
    }

}
