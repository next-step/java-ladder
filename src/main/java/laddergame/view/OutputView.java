package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.domain.Name.MAX_NAME_LENGTH;

public class OutputView {
    public static void printGameMap(List<Name> userNames, Ladder ladder) {
        System.out.println(makeNameString(userNames));
        ladder.getPoints().stream()
                .map(line -> makeLineString(line))
                .forEach(System.out::println);
    }

    private static String makeNameString(List<Name> userNames) {
        return userNames.stream()
                .map(name -> " ".repeat(1 + MAX_NAME_LENGTH - name.getName().length()) + name.getName())
                .collect(Collectors.joining());
    }

    private static String makeLineString(Line line) {
        return line.getLine().stream()
                .map(point -> point ? "-----|" : "     |")
                .collect(Collectors.joining());
    }
}
