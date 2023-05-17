package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Users;

public class OutputView {

    private static final int WIDTH_OUT_OF_RANGE_BLOCK_NUMBER = 1;
    private static final int NAME_PADDING_RANGE = 5;

    private static final String HEIGHT_SEPARATOR = "|";
    private static final String LINE_SEPARATOR = "-----";
    private static final String NOT_LINE_SEPARATOR = "     ";

    private static final String LADDER_RESULT_MENT = "실행결과";

    public static void drawLadder(Ladder ladder, Users users) {
        System.out.println(LADDER_RESULT_MENT);
        System.out.println();
        drawUsers(users);
        for (int height = 0; height < ladder.height(); height++) {
            drawHeight(ladder, users, height);
        }
    }

    private static void drawUsers(Users users) {
        for (String name : users.userNames()) {
            System.out.printf("%-" + NAME_PADDING_RANGE + "s ", name);
        }
        System.out.println();
    }

    private static void drawHeight(Ladder ladder, Users users, int height) {
        for (int width = 0; width < users.userCount() - WIDTH_OUT_OF_RANGE_BLOCK_NUMBER; width++) {
            System.out.print(HEIGHT_SEPARATOR);
            drawLine(ladder, height, width);
        }
        System.out.print(HEIGHT_SEPARATOR);
        System.out.println();
    }

    private static void drawLine(Ladder ladder, int height, int width) {
        if (ladder.hasLine(getLine(height, width), height)) {
            System.out.print(LINE_SEPARATOR);
            return;
        }
        System.out.print(NOT_LINE_SEPARATOR);
    }

    private static Line getLine(int height, int width) {
        return new Line(new Position(width, height), new Position(width + 1, height));
    }

}
