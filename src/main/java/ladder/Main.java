package ladder;

import ladder.domain.*;
import ladder.service.LadderGenerator;
import ladder.service.InputService;
import ladder.view.Input;
import ladder.view.Output;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();

        Participants participants = new Participants(InputService.parseParticipants(input.inputParticipants()));

        Results results = new Results(InputService.parseResults(input.inputResults()));
        InputService.validateResults(participants.getParticipantsCount(), results.getResultsCount());

        Ladder ladder = LadderGenerator.generateLadder(
                InputService.validateLadderHeight(input.inputLadderHeight()),
                participants.getParticipantsCount() - 1
        );

        Game game = new Game(ladder, participants, results);

        Output.showGameView(participants, ladder, results);

        String name = input.inputGetResult();
        InputService.validateGetResultInput(name, participants);

        ShowResultType showResultType = InputService.getResultType(name);

        if (showResultType.equals(ShowResultType.INDIVIDUAL)) {
            Output.showIndividualResult(game.getIndividualResult(participants.findParticipant(name)));
        }

        if (showResultType.equals(ShowResultType.ALL)) {
            Output.showAllResult(game.getAllResult());
        }
    }
}
