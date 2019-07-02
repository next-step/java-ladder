package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;

import java.util.List;

public class ResultView {
    public static void printUsers(Players players) {
        List<String> names = players.getPlayersNames();
        int max = players.getMaxNameLength();

        println(fillSpace(names, max));
    }

    private static String fillSpace(List<String> names, int max) {
        StringBuilder builder = new StringBuilder();
        for (String name : names) {
            if (name.length() < max) {
                int offset = max - name.length();
                for (int i = 0; i < offset; i++) {
                    builder.append(" ");
                }
            }

            builder.append(name).append(" ");
        }

        return builder.toString();
    }

    public static void printLadder(int maxLength, Ladder ladder) {
        ladder.getLadder().stream()
                .forEach(line -> printLine(maxLength, line));
    }

    private static void printLine(int maxLength, Line line) {
        println(getLineFormatted(maxLength, line));
    }

    private static String getLineFormatted(int maxLength, Line line) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0 ; i < maxLength - 1 ; i++) {
            builder.append(" ");
        }

        builder.append('|');
        line.getLine().stream()
                .forEach(isLine -> {
                    String type = getLadderType(isLine);

                    for (int i = 0 ; i < maxLength + 1 ; i++) {
                        builder.append(type);
                    }

                    builder.append('|');
                });


        return builder.toString();
    }

    private static String getLadderType(boolean isLine) {
        if (isLine) {
            return "-";
        }

        return " ";
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
