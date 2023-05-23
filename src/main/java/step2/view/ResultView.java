package step2.view;

import step2.domain.GameUsers;
import step2.domain.Ladder;
import step2.domain.Line;
import step2.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private final static String LINE = "|";
    private final static String BRIDGE = "-----";

    public static void displayLadder(GameUsers users, Ladder ladder) {
        printUserNames(users.getUsers());
        ArrayList<Line> lines = ladder.getLines();

        IntStream.range(0, ladder.getHeight())
                .forEach(position -> {
                    System.out.print(" ".repeat(BRIDGE.length()));
                    lines.forEach(line -> {
                        System.out.print(LINE);
                        System.out.print(line.isPresent(position) ? BRIDGE : " ".repeat(BRIDGE.length()));
                    });
                    System.out.println();
                });
    }

    private static void printUserNames(List<User> users) {
        users.forEach(user -> System.out.print(user.getFiveCharacterName() + " "));
        System.out.println();
    }
}
