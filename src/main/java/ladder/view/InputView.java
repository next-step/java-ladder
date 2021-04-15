package ladder.view;

import ladder.domain.Players;
import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String PLAYER_DELIMITER = ",";

    private final Scanner scanner;
    private Players players;
    private int ladderHeight;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void inputPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputPlayers = scanner.nextLine();
        players = Players.of(Arrays.asList(StringUtil.split(inputPlayers.trim(), PLAYER_DELIMITER)));
    }

    public void inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
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
