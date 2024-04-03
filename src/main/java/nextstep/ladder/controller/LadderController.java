package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        List<Person> names = InputView.getPersonNames();
        int countOfPerson = names.size();
        int height = InputView.getHeight();

        OutputView.printLadder(height, names, new LadderGame(height, countOfPerson));
    }

}
