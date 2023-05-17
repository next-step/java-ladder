package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.strategy.RandomLadderPointGenerateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        Participants participants = InputView.inputParticipantsNames();
        List<LadderResult> inputLadderResults = InputView.inputLadderResults();
        Height height = InputView.inputMaxLadderHeight();

        Ladder ladder = new Ladder(participants.size(), height.getHeight(), new RandomLadderPointGenerateStrategy());

        OutputView.printParticipantNames(participants);
        OutputView.printLadders(ladder);
        OutputView.printInputResults(inputLadderResults);

        LadderGame ladderGame = new LadderGame(participants, ladder, inputLadderResults);
        LadderResults ladderResults = ladderGame.play();

        OutputView.printResultByParticipant(InputView.inputParticipantNameForResult(), ladderResults);
    }
}
