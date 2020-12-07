package nextstep.ladder.view;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Users;

import java.util.List;

public class ResultView {
    private static final String RESULT_MENTION = "실행결과";
    private static final String VERTICAL = "|";
    private static final String BAR = "-----";

    public void printResultMention() {
        System.out.println();
        System.out.println(RESULT_MENTION);
    }

    public void printUsers(Users users) {
        users.getUsers()
                .forEach(user -> System.out.print(String.format("%5s ", user.getName())));
    }

    public void drawLadders(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> drawLine(line.getPoints()));
    }

    private void drawLine(List<Point> points) {
        enterLine();
        points.forEach(this::checkDirection);
    }

    private void enterLine() {
        System.out.println();
    }

    private void checkDirection(Point point) {
        if(point.getDirection() == Direction.RIGHT) {
            drawRight();
        }

        if(point.getDirection() == Direction.LEFT) {
            drawLeft();
        }

        if(point.getDirection() == Direction.FORWARD) {
            drawForward();
        }
    }

    private void drawRight() {
        System.out.print(String.format("%5s", VERTICAL));
        System.out.print(String.format("%5s", BAR));
    }

    private void drawLeft() {
        System.out.print(String.format("%s ", VERTICAL));
    }

    private void drawForward() {
        System.out.print(String.format("%5s ", VERTICAL));
    }
}
