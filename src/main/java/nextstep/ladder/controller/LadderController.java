package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args){
        InputView inputView = new InputView();

        String people = inputView.inputPeople();
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(people, ladderHeight);

        ResultView resultView = new ResultView();
        resultView.printLadder(ladder.getPeople(), ladderHeight, ladder.getLines().getLines());
    }




}
