package ladder.view;

import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Results;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static Players inputPlayers() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", DELIMITER);
        return Players.valueOf(SCANNER.nextLine().split(DELIMITER));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = SCANNER.nextInt();
        SCANNER.nextLine();
        return height;
    }

    public static Results inputResults() {
        System.out.printf("실행 결과를 입력하세요. (결과는 쉼표(%s)로 구분하세요%n", DELIMITER);
        return Results.valueOf(SCANNER.nextLine().split(DELIMITER));
    }

    public static Player inputPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return Player.name(SCANNER.nextLine());
    }

}
