package ladder.controller;

import ladder.domain.*;
import ladder.dto.PlayerResultDto;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class LadderController {

    private static final String GAME_END_NAME = "all";

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        Results results = InputView.inputResults();
        int height = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(results, height);

        ResultView.print(players);
        ResultView.print(ladderGame.getLadder());
        ResultView.print(results);

        String playerName = InputView.inputPlayerName();

        while (!playerName.equals(GAME_END_NAME)) {
            Player inputPlayer = players.findByName(playerName);
            Result result = ladderGame.resultOf(inputPlayer);
            ResultView.print(result);
            playerName = InputView.inputPlayerName();
        }

        for (Player player : players.getPlayers()) {
            Result result = ladderGame.resultOf(player);
            ResultView.print(player, result);
        }
    }
}
