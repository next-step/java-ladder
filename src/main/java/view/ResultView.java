package view;

import domain.Ladder;
import util.Console;

import java.util.Map;

public class ResultView {
    public static void printLine(Ladder ladder) {
        Console.print(ladder.toString());
    }

    public static void result(String player, String value) {
        Console.print(player + ": " + value);
    }

    public static void allResult(Map<String, String> map) {
        map.forEach((k, v) -> Console.print(k + ": " + v));
    }
}
