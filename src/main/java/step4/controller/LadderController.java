package step4.controller;


import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;
import java.util.Map;


public class LadderController {

    public static Players getPlayers() {
        return Players.of(InputView.getPlayers());
    }

    public static Prizes getPrizes(int playerSize) {
        return Prizes.of(InputView.getPrizes(), playerSize);
    }

    public static int getHeight() {
        return InputView.getLadderHeight();
    }

    public static Ladder createLines(int size, int height) {
        return Ladder.of(height, size, new LadderPointGenerator());
    }

    public static void showResult(Players players, Ladder ladder, Prizes prizes) {
        ResultView.printPlayer(players);
        ResultView.printLadder(ladder);
        ResultView.printPrizes(prizes);
    }

    public static String getPlayerName() {
        return InputView.getPlayer();
    }

    public static Players getPlayersByname(Players players, String playerName) {
        List<Player> playersByName = players.getPlayersByName(playerName);
        return new Players(playersByName);
    }

    public static Players getLadderResults(Players players, Ladder ladder) {
        return players.getEndResult(ladder);
    }

    public static Map<Player, String> getAward(Players players, Prizes prizes) {
        return prizes.getAward(players.getPlayers());
    }

    public static void showAward(Map<Player, String> award) {
        ResultView.printLadderAward(award);
    }
}
