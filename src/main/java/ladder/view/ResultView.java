package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.domain.Point;

import java.util.List;

public class ResultView {
    public static void printUsers(Players players) {
        List<String> names = players.getPlayersNames();
        int max = players.getMaxNameLength();

        println(fillSpace(names, max));
    }

    private static String fillSpace(List<String> names, int max) {
        StringBuilder builder = new StringBuilder();

        names.stream()
                .forEach(name -> {
                    builder.append(addSpaces(name.length(), max));
                    builder.append(name).append(" ");
                });

        return builder.toString();
    }

    private static String addSpaces(int nameLength, int max) {
        if (nameLength >= max) return "";

        StringBuilder builder = new StringBuilder();
        int offset = max - nameLength;
        for (int i = 0; i < offset; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }

    public static void printLadder(Ladder ladder, int maxNameLength) {
        ladder.getLines().stream()
                .forEach(line -> println(printLine(line, maxNameLength)));

    }

    private static String printLine(Line line, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        for (Point point : line.getPoints()) {
            builder.append(printPoint(point, maxNameLength));
        }

        return builder.toString();
    }

    private static String printPoint(Point point, int maxNameLength) {
        return getLadderBlock(point.current(),  maxNameLength);
    }

    private static String getLadderBlock(boolean isLine, int maxLength) {
        StringBuilder builder = new StringBuilder();
        String type = getLadderType(isLine);
        for (int i = 0 ; i < maxLength + 1 ; i++) {
            builder.append(type);
        }

        builder.append('|');
        return builder.toString();
    }

    private static String getLadderType(boolean isLine) {
        return isLine ? "-" : " ";
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
