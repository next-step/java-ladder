package nextstep.ladder.view;

import nextstep.ladder.domain.line.Ladder;
import nextstep.ladder.domain.line.LadderHeight;
import nextstep.ladder.domain.user.Users;

import java.util.stream.IntStream;


public class ResultView {

    private static final int START = 0;
    private static final int WIDTH_OUT_OF_RANGE_BLOCK_NUMBER = 1;
    private static final String RESULT = "\n실행결과";
    private static final String HEIGHT_SEPARATOR = "|";
    private static final String LINE_SEPARATOR  = "-----";
    private static final String NO_LINE_SEPARATOR  = "     ";

    private void printUserName(Users users) {
        System.out.println(users.toString());
    }

    public void printLadder(Ladder ladder, LadderHeight ladderHeight, Users users) {
        System.out.println(RESULT);
        System.out.println();
        printUserName(users);
        ladderHeight.toStream()
                .forEach(height -> printHeight(ladder, height, users));
    }

    private void printHeight(Ladder ladder, int height, Users users) {
        IntStream.range(START, users.userCount() - WIDTH_OUT_OF_RANGE_BLOCK_NUMBER).forEach(width -> {
            System.out.print(HEIGHT_SEPARATOR);
            printLine(ladder, height, width);
        });
        System.out.print(HEIGHT_SEPARATOR);
        System.out.println();
    }

    private void printLine(Ladder ladder, int height, int width) {
        if(ladder.hasLine(height, width)) {
            System.out.print(LINE_SEPARATOR);
            return;
        }
        System.out.print(NO_LINE_SEPARATOR);
    }
}

