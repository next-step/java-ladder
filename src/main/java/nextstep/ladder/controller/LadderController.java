package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Ladders;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;
import nextstep.ladder.ladderview.InputView;
import nextstep.ladder.ladderview.ResultView;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Participants participants = new Participants(inputView.inputName());
        int numberOfParticipants = participants.getParticipantCount();

        Results results = new Results(inputView.inputResult(numberOfParticipants));
        int height = inputView.inputHeight();

        Ladders ladders = new Ladders(height, numberOfParticipants);
        ladders.createLines();
        resultView.printResult(participants.getParticipants(), ladders.getLadderState(), results.getResults());

        LadderResult ladderResult = new LadderResult(ladders, participants, results);
        printReulstUntilInputIsAll(ladderResult);

    }

    private void printReulstUntilInputIsAll(LadderResult ladderResult) {
        String player = inputView.inputResultOfPlayer();
        resultView.printResultOfPlayer(ladderResult,player);
        if(checkInputIsAll(player)) {
            printReulstUntilInputIsAll(ladderResult);
        }
    }

    private static boolean checkInputIsAll(String player) {
        return !player.equals("all");
    }

}
