package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.strategy.BridgeStrategy;
import nextstep.ladder.utils.Util;

import java.util.List;
import java.util.Map;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.OutputView.printLadder;
import static nextstep.ladder.view.OutputView.printResult;

public class LadderGame {

    public static final String DELIMITER = ",";
    private final BridgeStrategy strategy;

    public LadderGame(BridgeStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        Participants participants = new Participants(getParticipantNames());
        LadderResult result = LadderResult.of(participants, getResultList());
        Height height = new Height(getLadderHeight());
        Ladder ladder = Ladder.of(participants,height,strategy);

        printLadder(participants, result, ladder);

        Map<String, String> gameResult = ladder.generateResult(participants, result);
        loopResult(participants, gameResult);
    }

    private void loopResult(Participants participants, Map<String, String> gameResult) {
        while (true){
            String input = getNameOrCodeForResult();
            if (input.equals(Code.EXIT.getCode())) {
                break;
            }
            participants.validateResultInput(input);
            printResult(input, gameResult);
        }
    }

    private List<String> getResultList() {
        return Util.separateToList(getResults(), DELIMITER);
    }

    private List<String> getParticipantNames() {
        return Util.separateToList(getParticipants(), DELIMITER);
    }
}
