package ladder;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String PLAYER_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private final Players players;
    private final int ladderHeight;

    public InputView(String players, int ladderHeight) {
        this.players = makePlayers(players);
        this.ladderHeight = ladderHeight;
    }

    private Players makePlayers(String players) {
        return Players.of(Arrays.asList(split(players.trim())));
    }

    public static String inputPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private static String[] split(String inputString) {
        if (isIllegalArgument(inputString)) {
            throw new IllegalArgumentException();
        }
        return inputString.split(PLAYER_DELIMITER);
    }

    private static boolean isIllegalArgument(String inputString) {
        return inputString == null || "".equals(inputString);
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public Players getPlayers() {
        return players;
    }
}
