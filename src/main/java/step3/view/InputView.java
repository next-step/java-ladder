package step3.view;

import step3.domain.Height;
import step3.domain.Players;
import step3.domain.Results;

import java.util.Scanner;

public class InputView {
    public static final String DELIMITER = ",";
    public static final String INPUT_PLAYERS_TEXT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_TEXT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_HEIGHT_TEXT = "최대 사다리 높이는 몇 개인가요?";

    public static final Scanner SCANNER = new Scanner(System.in);

    public static Players inputPlayers() {
        System.out.println(INPUT_PLAYERS_TEXT);
        return Players.from(SCANNER.nextLine());
    }

    public static Results inputResults(int countOfPlayers) {
        System.out.println(INPUT_RESULT_TEXT);
        return Results.from(SCANNER.nextLine(), countOfPlayers);
    }

    public static Height inputHeight() {
        System.out.println(INPUT_HEIGHT_TEXT);
        return new Height(SCANNER.nextInt());
    }

    public static String inputPlayer() {
        return SCANNER.next();
    }
}
