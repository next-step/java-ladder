package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.stream.IntStream;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String VERTICAL_LINE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_LINE_BLANK = "     ";
    private static final String PRINT_NAME_WIDTH_FORMAT = "%6s";


    private ResultView() {
    }

    public static void printResult(Users users, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        printUsers(users);
        printLadder(ladder);
    }

    private static void printUsers(Users users) {
       for (User user : users.getUsers()) {
           System.out.print(String.format(PRINT_NAME_WIDTH_FORMAT, user.getName()));
       }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        IntStream.range(0, ladder.size())
                .mapToObj(ladder::getLine)
                .forEach(line -> {
                    printPoints(line);
                    System.out.println();
                });
    }

    private static void printPoints(Line line) {
        IntStream.range(0, line.size())
                .forEach(j -> {
                    boolean point = line.getIndex(j).isLeft();
                    printPoint(point);
                    System.out.print(VERTICAL_LINE);
                });
    }

    private static void printPoint(boolean point) {
        System.out.print((point) ? LADDER_LINE : LADDER_LINE_BLANK);
    }
}
