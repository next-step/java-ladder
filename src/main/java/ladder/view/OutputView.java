package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static String RESULT_MSG = "사다리 결과";
    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void print(List<String> names) {
        names.stream().forEach(name -> System.out.print(String.format("%-6s", name)));
        System.out.println();
    }

    public static void printLadder(List<Line> lines) {
        lines.stream().forEach(line -> print(line));
    }

    private static void print(Line line) {
        line.getDots().stream().map(dot -> getDotValueToString(dot)).forEach(System.out::print);
        System.out.println();
    }

    public static void printAllResult(Map<String, String> result) {
        result.entrySet().stream()
                .forEach(entry -> printResult(entry.getKey(), entry.getValue()));
    }


    public static void printResult(String key, String result) {
        System.out.println(key + ":" + result);
    }

    private static String getDotValueToString(Boolean value) {

        if (value) {
            return "|" + "-".repeat(Player.NAME_MAX_LENGTH);
        }
        return "|" + " ".repeat(Player.NAME_MAX_LENGTH);
    }

    public static void printGeneratedLadder(LadderGame ladderGame, String[] inputedResult) {
        printMsg(RESULT_MSG);
        print(ladderGame.getPlayers().getPlayerNames());
        printLadder(ladderGame.getLines());
        print(Arrays.asList(inputedResult));
    }
}
