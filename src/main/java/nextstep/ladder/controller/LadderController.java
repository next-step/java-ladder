package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.strategy.RandomLadderPointGenerateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public static void main(String[] args) {
        Participants participants = InputView.inputAndExtractParticipantNames();
        Height height = InputView.inputMaxLadderHeight();

        LadderGame ladderGame = new LadderGame(participants, height, new RandomLadderPointGenerateStrategy());

        OutputView.printParticipantNames(ladderGame.getParticipantNames());
        OutputView.printLadders(ladderGame.getLines());
    }
}
