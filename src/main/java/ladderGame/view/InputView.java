package ladderGame.view;

import ladderGame.domain.Players;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static Players aksPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");
        String playerNames = scanner.nextLine();
        return Players.of(Arrays.asList(playerNames.split(",")));
    }

    public static int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }
}
