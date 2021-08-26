package step2.ladderGame.view;

import step2.ladderGame.domain.ladder.Ladder;
import step2.ladderGame.domain.ladder.Line;
import step2.ladderGame.domain.ladder.Point;
import step2.ladderGame.domain.user.Users;

public final class ResultView {

    public void printUserNames(Users users) {
        StringBuilder builder = new StringBuilder();
        System.out.println("\n실행결과\n");
        users.getUsers().forEach(user -> builder.append(user.getName()).append("     "));
        System.out.println(builder);
    }

    public void printLadder(Ladder ladder, int height) {

        for(int i = 0; i < height; i++) {

        }






        /*
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
        */
    }

    private void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        for (Point point : line.getPoints()) {
            builder.append("|");
            builder.append(printBetweenLine(point));
        }
        System.out.println(builder);
    }

    private String printBetweenLine(Point point) {
        if (point.hasHorizontalLine()) {
            return "-----";
        }
        return "     ";
    }

}
