package ladder.controller;

import ladder.domain.Player;
import ladder.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderController {

    private static final String NAME_REX_PATTERN = ",";

    public static void main(String[] args) {
        ladderGame();
    }

    public static void ladderGame() {
        InputView inputView = new InputView(new Scanner(System.in));

        List<Player> players = addPlayers(inputView.inputPlayers());
        int ladderHeight = inputView.inputLadderHeight();
    }

    private static List<Player> addPlayers(String playerText) {
        List<Player> players = new ArrayList<>();

        Arrays.stream(playerText.split(NAME_REX_PATTERN))
                .map(Player::new)
                .forEach(players::add);

        return players;
    }
}
