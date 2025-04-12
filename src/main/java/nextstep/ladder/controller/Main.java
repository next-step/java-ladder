package nextstep.ladder.controller;

import nextstep.ladder.module.Board;
import nextstep.ladder.module.BoardResult;
import nextstep.ladder.module.Height;
import nextstep.ladder.module.Name;
import nextstep.ladder.module.NameList;
import nextstep.ladder.module.ResultList;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        NameList peopleNames = new NameList(inputView.getPeopleNames());
        ResultList resultNames = new ResultList(inputView.getResultNames());
        Height height = new Height(inputView.getHeight());

        Game game = new Game(peopleNames, resultNames, height);
        Board board = game.createBoard();

        resultView.printBoard(board);
        resultView.printResultNames(resultNames);

        BoardResult boardResult = game.play(board);

        while (true) {
            Name wantedName = new Name(inputView.getWantedName());
            resultView.printResults(wantedName, boardResult);
            if (wantedName.equals(new Name("all"))) {
                break;
            }
        }
    }
}
