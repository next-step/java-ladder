package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final static String NAME_FORMAT = "%5s";
    private final static String LADDER_HEIGHT = "|";
    private final static String LADDER_LINE = "-----";
    private final static String LADDER_EMPTY = "     ";

    public static void resultLadder(List<User> users, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printUserName(users);
        System.out.println();
        printLadder(ladder);
    }

    private static void printUserName(List<User> users) {
        users.stream()
                .map(User::getUserName)
                .forEach(name ->
                System.out.print(String.format(NAME_FORMAT, name) + " "));
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadder()
                .stream()
                .map(ResultView::createLadder)
                .forEach(System.out::println);
    }

    private static String createLadder(Line line){
        return line.getLine()
                .stream()
                .map(isLine -> isLine ? LADDER_LINE : LADDER_EMPTY)
                .collect(Collectors.joining(LADDER_HEIGHT, "", LADDER_HEIGHT));
    }
}
