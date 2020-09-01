package ladder.view;

import ladder.domain.line.Height;
import ladder.domain.player.Players;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static Players inputPlayers() {
        System.out.println(INPUT_PLAYERS_MESSAGE);
        return Players.of(scanner.nextLine());
    }

    public static Height inputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return Height.of(scanner.nextInt());
    }
}
