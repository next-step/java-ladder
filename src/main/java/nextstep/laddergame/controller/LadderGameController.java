package nextstep.laddergame.controller;

import java.util.List;
import java.util.Objects;

import nextstep.laddergame.model.Goal;
import nextstep.laddergame.model.Ladder;
import nextstep.laddergame.model.Participant;
import nextstep.laddergame.model.Results;
import nextstep.laddergame.service.LadderGameService;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.ResultView;

public class LadderGameController {

    private final LadderGameService ladderGameService;

    public LadderGameController(LadderGameService ladderGameService) {
        this.ladderGameService = Objects.requireNonNull(ladderGameService, "ladderGameService");
    }

    public void start() {
        List<Participant> participants = InputView.acceptParticipants();
        List<Goal> goals = InputView.acceptGoals();
        Ladder ladder = new Ladder(participants.size(), InputView.acceptMaxLadderHeight());

        Results results = ladderGameService.play(participants, ladder, goals);

        ResultView.printLadder(participants, ladder.getLines(), goals);
        showResults(results);
    }

    private void showResults(Results results) {
        Participant participant;
        while (true) {
            participant = InputView.acceptParticipant();
            if (participant.isAll()) {
                ResultView.printResult(results.getAll());
                break;
            }
            ResultView.printResult(results, participant);
        }
    }
}
