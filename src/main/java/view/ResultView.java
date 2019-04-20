package view;

import domain.Ladder;
import domain.Players;
import domain.Result;
import util.Console;

import java.util.Map;

public class ResultView {
    public static void result(String player, String value) {
        Console.print(player + ": " + value);
    }

    public static void allResult(Map<String, String> map) {
        map.forEach((k, v) -> Console.print(k + ": " + v));
    }

    public static void printLadderBoard(Players players, Ladder ladder, Result result) {
        Console.print(players.toString());
        Console.print(ladder.toString());
        Console.print(result.toString());
    }
}
