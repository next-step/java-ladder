package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLadderGenerationResult(Users users, Ladder ladder) {
        System.out.println("실행결과\n");
        printUserNames(users);
        printLadder(ladder);
    }

    public static void printUserNames(Users users) {
        System.out.println(
                users.getUsers().stream()
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
        for (Point point : line.getPoints()) {
            lineRepresentation.append("|");
            if (point.isConnected()) {
                lineRepresentation.append("-".repeat(5));
            } else {
                lineRepresentation.append(" ".repeat(5));
            }
        }
        lineRepresentation.append("|");
        System.out.println(lineRepresentation);
    }
}
