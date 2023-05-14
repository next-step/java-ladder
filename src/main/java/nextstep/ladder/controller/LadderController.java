package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.ParticipantNames;
import nextstep.ladder.domain.strategy.RandomLadderPointGenerateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public static void main(String[] args) {
        ParticipantNames participantNames = InputView.inputAndExtractParticipantNames();
        Height height = InputView.inputMaxLadderHeight();

        LadderGame ladderGame = new LadderGame(participantNames, height, new RandomLadderPointGenerateStrategy());

        OutputView.printParticipantNames(ladderGame.getParticipantNames());
        OutputView.printLadders(ladderGame.getLines());
    }
}
