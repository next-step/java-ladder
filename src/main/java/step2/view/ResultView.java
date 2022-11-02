package step2.view;

import step2.domain.Ladder;
import step2.domain.Line;
import step2.domain.Users;

import java.util.concurrent.atomic.AtomicInteger;

public class ResultView {

    private static final String LADDER_SHAPE = "|";
    private static final String IS_LINE = "-";
    private static final String IS_BLANK = " ";
    private static final String RESULT_TEXT = System.lineSeparator()+"실행결과"+System.lineSeparator();
    private static final int REPEAT_COUNT = 5;

    public static void printLadderGame(Users users, Ladder ladder) {
        System.out.println(RESULT_TEXT);
        printNames(users);
        printLadders(ladder);
    }

    private static void printLadders(Ladder ladder) {
        ladder.lines.stream()
                .forEach(floor -> {
                    System.out.print(System.lineSeparator() + IS_BLANK.repeat(3));
                    printLines(floor);
                    System.out.print(LADDER_SHAPE);
                });
    }

    private static void printLines(Line floor) {
        floor.hasLine.stream()
                .forEach(isLine -> {
                    System.out.print(LADDER_SHAPE);
                    System.out.print(getLine(isLine.booleanValue()));
                });
    }

    private static String getLine(boolean isLine) {
        if (isLine) {
            return IS_LINE.repeat(REPEAT_COUNT);
        }
        return IS_BLANK.repeat(REPEAT_COUNT);
    }

    private static void printNames(Users users) {
        AtomicInteger index = new AtomicInteger();
        users.names.stream()
                .map(name -> getName(index, name))
                .forEach(System.out::print);
    }

    private static String getName(AtomicInteger index, String name) {
        if (index.getAndIncrement() != 0) {
            return IS_BLANK.repeat(REPEAT_COUNT - name.length()).concat(name).concat(IS_BLANK);
        }
        return name.concat(IS_BLANK.repeat(REPEAT_COUNT - name.length())).concat(IS_BLANK);
    }
}
