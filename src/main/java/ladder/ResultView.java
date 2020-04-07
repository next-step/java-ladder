package ladder;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ResultView {
    public static void printResult(List<String> users, List<Line> ladder) {
        printMessage("실행결과");

        renderUsers(users);
        renderLadder(ladder, generateLadderLine(ladder));
    }

    private static void renderUsers(List<String> users) {
        printMessage(
                users
                        .stream()
                        .collect(joining(" ")));
    }

    private static void renderLadder(List<Line> ladder, String line) {
        Stream
                .generate(() -> line)
                .limit(ladder.size())
                .collect(toList())
                .forEach(ResultView::printMessage);
    }

    private static String generateLadderLine(List<Line> ladder) {
        return Stream
                .generate(() -> "    |")
                .limit(ladder.get(0).getWidth())
                .collect(joining(""));
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
