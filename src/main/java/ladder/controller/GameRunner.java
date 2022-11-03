package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class GameRunner {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> participantNames = inputView.enterParticipantName();
        Points participants = Points.createPointsByNames(participantNames);
        List<String> winningItemNames = inputView.enterWinningItems(participantNames.size());
        Points winningItems = Points.createPointsByNames(winningItemNames);
        int ladderHeight = inputView.enterLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, participants.size() - 1, new RandomLineGenerator());
        LadderGame ladderGame = new LadderGame(ladder, participants);

        int maxNameSize = Math.max(participants.pointNameMaxSize(), winningItems.pointNameMaxSize());
        resultView.printLadderInitMessage();
        resultView.printNames(participants, maxNameSize);
        resultView.printLadder(ladder, maxNameSize);
        resultView.printNames(winningItems, maxNameSize);

        while(true) {
            String resultName = inputView.enterResultName();
            Points filteredPoints = ladderGame.filteredResultByName(resultName);
            resultView.printResult(filteredPoints, winningItems);
        }
    }
}
