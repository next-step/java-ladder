package laddergame.ui;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Result;
import laddergame.domain.ladder.Results;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.List;
import java.util.Map;

import static laddergame.util.StringUtils.fitLine;
import static laddergame.util.StringUtils.fitSpace;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";

    public static void printNames(Players players) {
        List<Player> playerList = players.getPlayers();
        playerList.forEach(player ->
                System.out.print(fitSpace(player.toString())));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> System.out.println(fitLine(line)));
    }

    public static void printResult(Results results) {
        results.getResultList()
                .forEach(result -> System.out.print(fitSpace(result.toString())));
        System.out.println();
    }

    public static void printWantResult(Map<Player, Result> results) {
        System.out.println(RESULT_MESSAGE);
        results.forEach((player, result) ->
                System.out.println(player + " : " + result));
    }
}
