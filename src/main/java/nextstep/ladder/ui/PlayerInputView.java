package nextstep.ladder.ui;

import nextstep.ladder.domain.Players;

import java.util.Scanner;

public class PlayerInputView {
    private static final String INPUT_PLAYERS_COMMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private Players players;

    public PlayerInputView(String playerList) {
        this.players = Players.create(playerList);
    }

    public static PlayerInputView createByUserInput(Scanner scanner) {
        return new PlayerInputView(getUserInputPlayers(scanner));
    }

    public Players getPlayers() {
        return players;
    }

    public int getPlayerSize() {
        return this.players.size();
    }

    private static String getUserInputPlayers(Scanner scanner) {
        System.out.println(INPUT_PLAYERS_COMMENT);
        return scanner.nextLine();
    }
}
