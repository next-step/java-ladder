package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

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

    public static Lines createLines(int size, int height) {
        return Lines.of(height, size, new PointCondition());
    }

    public static void showResult(Players players, Lines lines, Prizes prizes) {
        ResultView.printPlayer(players);
        ResultView.printLadder(lines);
        ResultView.printPrizes(prizes);
    }

    public static String getPlayerName() {
        return InputView.getPlayer();
    }

    public static Players getPlayersByname(Players players, String playerName) {
        List<Player> playersByName = players.getPlayersByName(playerName);
        return new Players(playersByName);
    }

    public static Players getLadderResults(Players players, Lines lines) {
        return players.getResult(lines);
    }

    public static Map<Player, String> getAward(Players players, Prizes prizes) {
        Award award = new Award(players.getPlayers(), prizes.getPrizes());
        return award.getAward();
    }

    public static void showAward(Map<Player, String> award) {
        ResultView.printLadderAward(award);
    }
}
