package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Players players = inputView.getJoinMembers();
        int ladderCount = inputView.getLadderCount();

        Ladder ladder = new Ladder(ladderCount, players);

        resultView.ladderView(ladder, players);
    }

}
