package nextstep.ladder.view;

import java.util.Scanner;

public class PlayerConsoleInput {

    private static final String PLAYERS_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final Scanner scanner = new Scanner(System.in);

    public static String askPlayers() {
        System.out.println(PLAYERS_QUESTION);
        return scanner.nextLine();
    }
}
