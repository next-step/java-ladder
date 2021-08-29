package nextstep.ladder.view;

import nextstep.ladder.util.InputUtils;

import java.util.Scanner;

public class ResultConsoleInput {

    private static final String PLAYERS_QUESTION = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final Scanner scanner = new Scanner(System.in);

    public static String askResults() {
        System.out.println(PLAYERS_QUESTION);
        String players = scanner.nextLine();
        InputUtils.requireNonNull(players);
        return players;
    }
}
