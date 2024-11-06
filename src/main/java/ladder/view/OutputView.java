package ladder.view;

import ladder.domain.Line;
import ladder.domain.Player;

import java.util.List;
import java.util.Map;

public class OutputView {
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

}
