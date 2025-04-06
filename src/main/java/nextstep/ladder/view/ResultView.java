package nextstep.ladder.view;

import nextstep.ladder.module.Board;
import nextstep.ladder.module.Line;

public class ResultView {

    public void printBoard(Board board) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println();
        printPeopleNames(board);
        printLinesAndLadders(board);
    }

    private void printPeopleNames(Board board) {
        for (String name : board.names()) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
    }

    private void printLinesAndLadders(Board board) {
        for (Line line : board.lines()) {
            System.out.println(line);
        }
    }

}
