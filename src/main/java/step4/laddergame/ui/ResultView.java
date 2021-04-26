package step4.laddergame.ui;


import step4.laddergame.domain.ladder.Ladder;
import step4.laddergame.domain.ladder.Result;
import step4.laddergame.domain.ladder.Results;
import step4.laddergame.domain.player.Player;
import step4.laddergame.domain.player.Players;

import java.util.List;
import java.util.Map;

import static laddergame.util.StringUtils.fitSpace;
import static step4.laddergame.util.StringUtils.fitLine;

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

    public static void printWantResult(Result result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
    }

    public static void printWantResults(Map<Player, Result> results) {
        System.out.println(RESULT_MESSAGE);
        results.forEach((player, result) ->
                System.out.println(player + " : " + result));
    }
}
