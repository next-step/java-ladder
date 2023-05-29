package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.engine.LadderCreator;
import nextstep.ladder.domain.factory.LadderFactoryBean;
import nextstep.ladder.domain.nextstep.NextStepLadder;
import nextstep.ladder.domain.strategy.BridgeStrategy;
import nextstep.ladder.view.NextStepOutputView;

import java.util.Map;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.NextStepOutputView.printResult;

public class NextStepLadderGame {
    private final BridgeStrategy strategy;

    public NextStepLadderGame(BridgeStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        Participants participants = new Participants(getParticipants());
        LadderResult result = LadderResult.of(participants, getResults());
        Height height = new Height(getLadderHeight());

        LadderCreator ladderCreator = LadderFactoryBean.createLadderFactory();
        NextStepLadder ladder = (NextStepLadder) ladderCreator.create(participants, height, strategy);

        NextStepOutputView.printLadder(participants, result, ladder);

        GameResult gameResult = ladder.run(participants, result);
        loopResult(participants, gameResult.getGameResult());
    }

    private void loopResult(Participants participants, Map<String, String> gameResult) {
        while (true){
            String input = getNameOrCodeForResult();
            if (input.equalsIgnoreCase(String.valueOf(Code.EXIT))) {
                break;
            }
            participants.validateResultInput(input);
            printResult(input, gameResult);
        }
    }
}
