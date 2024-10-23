package laddergame.v2.controller;

import laddergame.v2.domain.*;
import laddergame.v2.ui.ResultView;
import laddergame.v2.domain.generator.*;
import laddergame.v2.ui.InputView;

import java.util.List;
import java.util.NoSuchElementException;

public class LadderGameApplication {

    private static final String ALL_PLAYERS = "all";

    public static void main(String[] args) {
        LadderGenerator ladderGenerator = getLadderGenerator();

        Players players = InputView.getPlayerFromUser();
        int playerCount = players.size();

        LadderResult ladderResult = InputView.getResultsFromUser(playerCount);
        PlayResultGenerator resultGenerator = new LadderPlayResultGenerator(ladderResult);

        int ladderHeight = InputView.getMaxLadderHeightFromUser();
        Ladder ladder = ladderGenerator.generate(playerCount, ladderHeight);

        ResultView.showLadder(players, ladder, ladderResult);

        List<Integer> finalPositions = ladder.moveAll(playerCount);
        LadderPlayResult playResult = resultGenerator.generate(players, finalPositions);

        showGameResult(players, playResult);
    }

    private static LadderGenerator getLadderGenerator() {
        LineGenerator lineGenerator = new RandomLineGenerator();
        return new LineBasedLadderGenerator(lineGenerator);
    }

    private static void showGameResult(Players players, LadderPlayResult playResults) {
        while(true){
            String name = InputView.getResultPlayerFromUser();

            if (isShowAllPlayers(name)) {
                ResultView.showGamePlayResult(playResults);
                return;
            }

            try{
                Player player = players.findBy(name)
                                    .orElseThrow(() -> new NoSuchElementException("존재하지 않는 플레이어입니다. 다시 입력하세요"));
                ResultView.showGamePlayResult(player, playResults);
            }catch (NoSuchElementException e){
                ResultView.showErrorMessage(e);
            }
        }
    }

    private static boolean isShowAllPlayers(String playerName) {
        return playerName.equals(ALL_PLAYERS);
    }
}
