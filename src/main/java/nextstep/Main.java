package nextstep;

import nextstep.ladder.Ladder;
import nextstep.ui.InputView;
import nextstep.ui.OutputView;

public class Main {

    public static void main(String[] args) {
        var players = InputView.inputPlayerNames();
        var results = InputView.inputResults();
        var height = InputView.inputHeight();

        var ladder = new Ladder(players, height);

        OutputView.printResult(ladder, results);
        OutputView.searchResult(ladder, results);
    }
}

