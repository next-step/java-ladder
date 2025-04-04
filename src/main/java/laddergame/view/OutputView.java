package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Line;

import java.util.stream.Collectors;

public class OutputView {
    public static void printGameMap(String userNames, Ladder ladder) {
        System.out.println(userNames);
        ladder.getPoints().stream()
                .map(line -> makeLineString(line))
                .forEach(System.out::println);
    }

    private static String makeLineString(Line line) {
        return line.getLine().stream()
                .map(point -> point ? "-----|" : "     |")
                .collect(Collectors.joining());
    }
}
