package my.project.view;

import my.project.domain.Symbol;
import my.project.domain.User;
import my.project.domain.Ladder;
import my.project.domain.Users;

import java.util.stream.Collectors;

public class ResultView {
    public static final String TITLE = "실행결과\n";
    public static final String DELIMITER = " ";

    private ResultView() {
    }

    public static void print(Users users, Ladder ladder) {
        printTitle();
        printUsers(users);
        printLadder(ladder);
    }

    private static void printTitle() {
        System.out.println(TITLE);
    }

    private static void printUsers(Users users) {
        System.out.println(users.getUsers().stream()
                .map(User::getName)
                .collect(Collectors.joining(DELIMITER)));
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> System.out.println(
                        line.getPoints().stream()
                                .map(Symbol::getSymbol)
                                .collect(Collectors.joining())
                        )
                );
    }
}
