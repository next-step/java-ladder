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
        List<String> winningItemNames = inputView.enterWinningItems(participantNames.size());
        int ladderHeight = inputView.enterLadderHeight();
        InitialInformation initialInformation = new InitialInformation(participantNames, winningItemNames, ladderHeight);

        Ladder ladder = new Ladder(
                initialInformation.getLadderHeight(),
                initialInformation.calculatedLadderLength(),
                new RandomLineGenerator()
        );
        LadderGame ladderGame = new LadderGame(ladder, initialInformation.getParticipants());

        resultView.printLadderInitMessage();
        resultView.printNames(initialInformation.getParticipants(), initialInformation.maxNameSize());
        resultView.printLadder(ladder, initialInformation.maxNameSize());
        resultView.printNames(initialInformation.getWinningItems(), initialInformation.maxNameSize());

        while(true) {
            String resultName = inputView.enterResultName();
            Points filteredPoints = ladderGame.filteredResultByName(resultName);
            resultView.printResult(filteredPoints, initialInformation.getWinningItems());
            if (resultName.equals("all")) {
                break;
            }
        }
    }
}
