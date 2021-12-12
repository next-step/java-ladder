package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        Names names = new Names(InputView.inputPlayerName());
        Prizes prizes = Prizes.of(InputView.inputPrize(), names);
        Height height = new Height(InputView.inputLadderHeight());
        Ladder ladder = new Ladder(names, height);
        Winning winning = ladder.playerByPrize(names, prizes);

        ResultView.ladderMessage();
        ResultView.printNames(names);
        ResultView.printLadder(ladder);
        ResultView.printPrizes(prizes);

        while (true){
            ResultView.printLadderResult(winning, names.playerName(InputView.resultPlayerName()));
        }
    }
}
