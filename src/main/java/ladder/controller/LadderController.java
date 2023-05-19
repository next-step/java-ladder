package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderController {

    private static final String NAME_REX_PATTERN = ",";

    public static void main(String[] args) {
        ladderGame();
    }

    public static void ladderGame() {
        InputView inputView = new InputView(new Scanner(System.in));

        List<Player> players = addPlayers(inputView.inputPlayers());
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, players.size());

        ResultView resultView = new ResultView();

        resultView.printResult(players, ladder.getLines());
    }

    private static List<Player> addPlayers(String playerText) {

        return Arrays.stream(playerText.split(NAME_REX_PATTERN))
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
