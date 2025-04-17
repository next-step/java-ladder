package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.User;
import ladder.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLadderGenerationResult(List<User> users, Ladder ladder) {
        System.out.println("실행결과\n");
        printUserNames(users);
        printLadder(ladder);
    }

    public static void printUserNames(List<User> users) {
        System.out.println(
                users.stream()
                        .map(user -> String.format("%6s", user.getName()))
                        .collect(Collectors.joining())
                        .trim()
        );
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        StringBuilder lineRepresentation = new StringBuilder();
        lineRepresentation.append(" ".repeat(4));
        for (Boolean point : line.getPoints()) {
            lineRepresentation.append("|");
            if (point) {
                lineRepresentation.append("-".repeat(5));
            } else {
                lineRepresentation.append(" ".repeat(5));
            }
        }
        lineRepresentation.append("|");
        System.out.println(lineRepresentation);
    }
}
