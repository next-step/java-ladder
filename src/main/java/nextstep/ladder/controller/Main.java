package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.module.Board;
import nextstep.ladder.module.Height;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        List<String> peopleNames = inputView.getPeopleNames();
        Height height = new Height(inputView.getHeight());

        Game game = new Game(peopleNames, height);
        Board board = game.createBoard();
        board.createLines();
        board.createLadders();

        resultView.printBoard(board);
    }
}
