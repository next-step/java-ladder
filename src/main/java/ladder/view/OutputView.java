package ladder.view;

import ladder.domain.Line;
import ladder.domain.Player;

import java.util.List;

public class OutputView {
    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void print(List<String> names) {
        names.stream()
                .map(name -> name + " ".repeat(Player.NAME_MAX_LENGTH + 1 - name.length()))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void println(List<String> strings) {
        strings.stream().forEach(System.out::println);
    }

    public static void printLadder(List<Line> lines) {
        lines.stream().forEach(line -> print(line));
    }

    private static void print(Line line) {
        line.getDots().stream().map(dot -> getDotValueToString(dot)).forEach(System.out::print);
        System.out.println();
    }

    private static String getDotValueToString(Boolean value) {

        if (value) {
            return "|" + "-".repeat(Player.NAME_MAX_LENGTH);
        }
        return "|" + " ".repeat(Player.NAME_MAX_LENGTH);
    }

}
