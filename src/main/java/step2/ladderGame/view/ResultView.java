package step2.ladderGame.view;

import step2.ladderGame.domain.ladder.Ladder;
import step2.ladderGame.domain.ladder.Line;
import step2.ladderGame.domain.ladder.Point;
import step2.ladderGame.domain.user.Users;

public final class ResultView {

    private static final int NAME_SPACE = 6;
    private static final String BLANK = " ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public void printUserNames(Users users) {
        StringBuilder builder = new StringBuilder();
        System.out.println("\n실행결과\n");
        users.getUsers().forEach(
                user -> {
                    String blank = printBlank(user.getName());
                    builder.append(blank).append(user.getName());
                }
        );
        System.out.println(builder);
    }

    private String printBlank(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        int emptyLength = NAME_SPACE - name.length();

        while (emptyLength > 0) {
            stringBuilder.append(BLANK);
            emptyLength--;
        }

        return stringBuilder.toString();
    }

    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder builder = new StringBuilder();

        for (Point point : line.getPoints()) {
            builder.append(printBetweenLine(point));
            builder.append(VERTICAL_LINE);
        }

        System.out.println(builder);
    }

    private String printBetweenLine(Point point) {
        if (point.hasHorizontalLine()) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

}
