package nextstep.ladder.controller;

import nextstep.ladder.domain.factory.LaddersFactory;
import nextstep.ladder.domain.factory.ParticipantsFactory;
import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class Game {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();


    public void start() {
        List<String> userNames = inputView.receiveUserNames();
        Participants participants = ParticipantsFactory.generateByUserNames(userNames);

        int ladderCount = userNames.size() - 1;
        Integer ladderHeight = inputView.receiveLadderHeight();
        Ladders ladders = LaddersFactory.generateWithRandomStrategy(ladderCount, ladderHeight);

        resultView.printResult(participants, ladders);
    }
}
