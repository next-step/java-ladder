package ladder.controller;


import ladder.domain.Climber;
import ladder.domain.LadderMap;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    private InputView inputView;
    private OutputView outputView;
    private Climber climber;

    private LadderController() {
        this.inputView = InputView.of();
        this.outputView = OutputView.of();
        this.climber = Climber.of();
    }

    public static LadderController of() {
        return new LadderController();
    }

    public void climbLadder() {
        String userNames = inputView.userNamesReader();
        int ladderHeight = inputView.ladderHeightReader();

        LadderMap ladderMap = climber.createLadder(userNames, ladderHeight);
        List<String> climberNames = climber.getUserNames();

        outputView.printUsersName(climberNames);
        outputView.printLadderMap(ladderMap);
    }
}
