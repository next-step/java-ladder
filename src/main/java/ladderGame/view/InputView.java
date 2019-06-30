package ladderGame.view;

import ladderGame.domain.Player;
import ladderGame.domain.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {


    private static Scanner scanner = new Scanner(System.in);

    public static Players aksPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");
        String playerNames = scanner.nextLine();
        return Players.of(buildPlayers(playerNames.split(",")));
    }

    private static List<Player> buildPlayers(String[] split) {
        List<Player> players = new ArrayList<>();
        for (int position = 0; position < split.length; position++) {
            players.add(Player.of(split[position], position));
        }
        return players;
    }
}
