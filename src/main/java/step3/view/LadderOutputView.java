package step3.view;

import step3.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class LadderOutputView {
    private final static int PADDING = 1;

    public static void printLadderWithUsernamesAndResults(Users users, Ladder ladder, Results results) {
        System.out.println("실행결과");

        int maxLength = getMaxLadderUserWidth(users, results);

        printStringsWithPadding(users.getUsernames(), maxLength);

        printLadder(users, ladder, maxLength);

        printStringsWithPadding(results.getResultStrings(), maxLength);
    }

    public static void printLadderResults(List<User> users, List<Result> ladderResults) {
        System.out.println("실행결과");

        IntStream.range(0, Math.min(users.size(), ladderResults.size()))
                .forEach(i -> {
                    User user = users.get(i);
                    Result result = ladderResults.get(i);

                    System.out.printf("%s: %s%n", user.toOutputString(), result.toOutputString());
                });
    }

    private static int getMaxLadderUserWidth(Users users, Results results) {
        return Math.max(getMaxStringLength(users.getUsernames()), getMaxStringLength(results.getResultStrings()));
    }

    private static Integer getMaxStringLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .reduce(0, Integer::max);
    }

    private static void printStringsWithPadding(List<String> strings, int maxUnitWidth) {
        strings.stream()
                .map(s -> String.format("%-" + (maxUnitWidth + PADDING) +"s", s))
                .forEach(System.out::print);

        System.out.println();
    }

    private static void printLadder(Users users, Ladder ladder, int maxUnitWidth) {
        StreamSupport.stream(ladder.spliterator(), false)
                .map(l -> getLineOutput(users, l, maxUnitWidth))
                .map(s -> "|" + s + "|")
                .forEach(System.out::println);
    }

    private static String getLineOutput(Users users, Line l, int maxUnitWidth) {
        return IntStream.range(0, users.numberOf() - 1)
                    .mapToObj(i -> lineOrEmpty(l, i, maxUnitWidth))
                    .collect(Collectors.joining("|"));
    }

    private static String lineOrEmpty(Line l, int i, int maxUnitWidth) {
        return l.hasSidelineAt(i) ? repeat("-", maxUnitWidth) : repeat(" ", maxUnitWidth);
    }

    private static String repeat(String target, int n) {
        return String.join("", Collections.nCopies(n, target));
    }
}
