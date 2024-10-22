package laddergame.v1.controller;

import laddergame.v1.domain.*;
import laddergame.v1.ui.InputView;
import laddergame.v1.ui.ResultView;

import java.util.NoSuchElementException;

public class LadderGameApplication {

    private static final String ALL_PLAYERS = "all";

    public static void main(String[] args) {
        LadderLineGenerator generator = new RandomLineGenerator();

        Players players = InputView.getPlayerFromUser();
        int playerCount = players.size();

        LadderResult ladderResult = InputView.getGameResultsFromUser(playerCount);

        int ladderHeight = InputView.getMaxLadderHeightFromUser();;
        Ladder ladder =  new Ladder(playerCount, ladderHeight, generator);

        ResultView.showLadder(players, ladder, ladderResult);

        LadderGame game = new LadderGame(players, ladder, ladderResult);
        LadderPlayResult playResults = game.play();

        showGameResult(players, playResults);

    }

    private static void showGameResult(Players players, LadderPlayResult playResults) {
        while(true){
            String playerName = InputView.getResultPlayerFromUser();

            if (isShowAllPlayers(playerName)) {
                ResultView.showGamePlayResult(playResults);
                return;
            }

            try{
                Player player = players.findByName(playerName)
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
