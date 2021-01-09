package controller;

import domain.Ladder;
import domain.PersonList;
import view.InputView;
import view.ResultView;

public class LadderController {
    public static void gameStart() {
        String names = InputView.participationNames();
        int ladderHeight = InputView.ladderHeight();

        PersonList personList = new PersonList(names);
        Ladder ladder = new Ladder(ladderHeight, personList.size());

        ResultView.ladder(personList, ladder);
    }
}
