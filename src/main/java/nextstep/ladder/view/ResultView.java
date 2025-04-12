package nextstep.ladder.view;

import nextstep.ladder.module.Board;
import nextstep.ladder.module.Line;
import nextstep.ladder.module.Name;
import nextstep.ladder.module.Point;

public class ResultView {

    public void printBoard(Board board) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println();
        printPeopleNames(board);
        printLinesAndLadders(board);
    }

    private void printPeopleNames(Board board) {
        for (Name name : board.names()) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
    }

    private void printLinesAndLadders(Board board) {
        for (Line line : board.lines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        for (Point point : line.points()) {
            printPoint(point);
        }
        System.out.println();
    }

    public void printPoint(Point point) {
        System.out.printf("%5s", point.leftBridge().isBuilt() ? "-----|" : "     |");
    }
}
