package ladder.Controller;


import ladder.Domain.Climber;
import ladder.Domain.LadderMap;
import ladder.View.InputView;
import ladder.View.OutputView;

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
        int ladderHHeight = inputView.ladderHeightReader();

        LadderMap ladderMap = climber.createLadder(userNames, ladderHHeight);
        List<String> climberNames = climber.getUserNames();

        outputView.printUsersName(climberNames);
        outputView.printLadderMap(ladderMap);
    }
}
