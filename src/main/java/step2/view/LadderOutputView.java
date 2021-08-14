package step2.view;

import step2.Ladder;
import step2.Line;
import step2.User;
import step2.Users;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class LadderOutputView {
    private final static int PADDING = 1;

    public static void printLadderWithUsernames(Users users, Ladder ladder) {
        System.out.println("실행결과");

        int maxNameLength = getMaxNameLength(users);

        printUsernames(users, maxNameLength);

        System.out.println();

        printLadder(users, ladder, maxNameLength);
    }

    private static Integer getMaxNameLength(Users users) {
        return users.usernames().stream()
                .map(String::length)
                .reduce(Integer::max)
                .orElse(User.USER_NAME_MAX_LENGTH);
    }

    private static void printUsernames(Users users, int maxNameLength) {
        users.usernames().stream()
                .map(s -> String.format("%-" + (maxNameLength + PADDING) +"s", s))
                .forEach(System.out::print);
    }

    private static void printLadder(Users users, Ladder ladder, int maxNameLength) {
        StreamSupport.stream(ladder.spliterator(), false)
                .map(l -> getLineOutput(users, l, maxNameLength))
                .map(s -> "|" + s + "|")
                .forEach(System.out::println);
    }

    private static String getLineOutput(Users users, Line l, int maxNameLength) {
        return IntStream.rangeClosed(0, users.numberOf() - 2)
                    .mapToObj(i -> lineOrEmpty(l, i, maxNameLength))
                    .collect(Collectors.joining("|"));
    }

    private static String lineOrEmpty(Line l, int i, int maxNameLength) {
        return l.hasSidelineAt(i) ? repeat("-", maxNameLength) : repeat(" ", maxNameLength);
    }

    private static String repeat(String target, int n) {
        return String.join("", Collections.nCopies(n, target));
    }
}
