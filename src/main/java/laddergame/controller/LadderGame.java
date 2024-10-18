package laddergame.controller;

import laddergame.domain.LadderLineGenerator;
import laddergame.domain.Line;
import laddergame.domain.Player;
import laddergame.domain.Players;
import laddergame.ui.InputView;
import laddergame.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LadderLineGenerator generator;

    public LadderGame(InputView inputView, ResultView resultView, LadderLineGenerator generator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.generator = generator;
    }

    public void run() {
        Players players = getPlayers();
        int ladderHeight = getLadderHeight();
        List<Line> ladder = createLadder(ladderHeight, players.size());
        resultView.showLadderGameResult(players, ladder);
    }

    private Players getPlayers() {
        List<Player> players = inputView.getPlayerFromUser();
        return new Players(players);
    }

    private int getLadderHeight() {
        return inputView.getMaxLadderHeightFromUser();
    }

    private List<Line> createLadder(int ladderHeight, int playerCount) {
        List<Line> ladders = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Line line = new Line(playerCount, generator);
            ladders.add(line);
        }
        return ladders;
    }
}
