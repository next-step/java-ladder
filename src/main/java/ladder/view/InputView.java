package ladder.view;

import ladder.domain.Players;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private final Players players;
    private final int ladderHeight;

    public InputView(Players players, int ladderHeight) {
        this.players = players;
        this.ladderHeight = ladderHeight;
    }

    public static String inputPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public Players getPlayers() {
        return players;
    }

    public int playersCount() {
        return players.count();
    }
}
