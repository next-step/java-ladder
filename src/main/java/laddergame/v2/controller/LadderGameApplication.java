package laddergame.v2.controller;

import laddergame.v2.ui.ResultView;
import laddergame.v2.domain.Ladder;
import laddergame.v2.domain.LadderResult;
import laddergame.v2.domain.Players;
import laddergame.v2.domain.generator.*;
import laddergame.v2.ui.InputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGenerator ladderGenerator = getLadderGenerator();

        Players players = InputView.getPlayerFromUser();
        int playerCount = players.size();

        LadderResult ladderResult = InputView.getResultsFromUser(playerCount);
        PlayResultGenerator resultGenerator = new LadderPlayResultGenerator(ladderResult);

        int ladderHeight = InputView.getMaxLadderHeightFromUser();
        Ladder ladder = ladderGenerator.generate(playerCount, ladderHeight);

        ResultView.showLadder(players, ladder, ladderResult);

    }

    private static LadderGenerator getLadderGenerator() {
        LineGenerator lineGenerator = new RandomLineGenerator();
        return new LineBasedLadderGenerator(lineGenerator);
    }
}
