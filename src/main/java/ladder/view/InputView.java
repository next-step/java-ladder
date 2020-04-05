package ladder.view;

import ladder.domain.Players;

import java.util.Scanner;

public class InputView {
    private static final String PLAYERS_DELIMETER = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static Players inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Players(scanner.next().split(PLAYERS_DELIMETER));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
