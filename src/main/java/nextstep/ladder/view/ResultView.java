package nextstep.ladder.view;

import java.util.Map;

import nextstep.ladder.module.Board;
import nextstep.ladder.module.BoardResult;
import nextstep.ladder.module.Line;
import nextstep.ladder.module.Name;
import nextstep.ladder.module.Point;
import nextstep.ladder.module.Result;
import nextstep.ladder.module.ResultList;

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
            System.out.printf("%5s ", name.value());
        }
        System.out.println();
    }

    public void printResultNames(ResultList resultNames) {
        for (Result result : resultNames) {
            System.out.printf("%5s ", result.value());
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

    public void printResults(Name wantedName, BoardResult boardResult) {
        System.out.println();
        System.out.println("실행 결과");
        if (wantedName.equals(new Name("all"))) {
            for (Map.Entry<Name, Result> entry : boardResult.all().entrySet()) {
                System.out.println(entry.getKey().value() + " : " + entry.getValue().value());
            }
            return;
        }
        System.out.println(boardResult.of(wantedName).value());
    }
}
