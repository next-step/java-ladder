package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.strategy.RandomLadderPointGenerateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public static void main(String[] args) {
        Participants participants = InputView.inputParticipantsNames();
        String inputLadderResults = InputView.inputLadderResults();
        Height height = InputView.inputMaxLadderHeight();

        Lines lines = new Lines(participants.size(), height.getHeight(), new RandomLadderPointGenerateStrategy());
        LadderResults ladderResults = new LadderResults(participants, inputLadderResults);

        OutputView.printParticipantNames(participants);
        OutputView.printLadders(lines);
        OutputView.printLadderResults(ladderResults);

        OutputView.printResultByParticipant(InputView.inputParticipantNameForResult(), ladderResults);
    }
}
