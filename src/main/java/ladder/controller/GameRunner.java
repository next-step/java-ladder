package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.RandomLineGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class GameRunner {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> participantNames = inputView.enterParticipantName();
        int ladderHeight = inputView.enterLadderHeight();

        Ladder ladder = new Ladder(participantNames, ladderHeight, new RandomLineGenerator());
        int namesMaxLength = ladder.getNamesMaxLength();
        List<Line> lines = ladder.getLines();

        ResultView resultView = new ResultView();
        resultView.printResultInitMessage();
        resultView.printParticipantNames(participantNames, namesMaxLength);
        resultView.printLadder(lines, namesMaxLength);
    }
}
