package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public static void main(String[] args) {
        String line = InputView.getPersonNames();
        String[] names = line.split(",");
        int countOfPerson = names.length;

        int height = InputView.getHeight();

        OutputView.printHeight(height);
        OutputView.printNames(names);
        OutputView.printLadder(new LadderGame(height, countOfPerson));
    }

}
