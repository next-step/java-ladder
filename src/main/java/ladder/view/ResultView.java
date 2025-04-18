package ladder.view;

import ladder.domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLadderGenerationResult(Ladder ladder) {
        System.out.println("실행결과\n");
        printUserNames(ladder.getUsers());
        printLadder(ladder);
        printResultValues(ladder.getResults());
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

    public static void printResultValues(Results results) {
        System.out.println(
                results.getResults().stream()
                        .map(result -> String.format("%6s", result.getValue()))
                        .collect(Collectors.joining())
                        .trim()
        );
    }

    public static void printFindResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(result.getValue());
    }

    public static void printFindResults(Map<User, Result> results) {
        System.out.println("실행 결과");
        results.forEach((user, result) -> System.out.println(user.getName() + " : " + result.getValue()));
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
