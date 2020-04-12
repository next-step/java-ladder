package ladder.controller;


import ladder.domain.Climber;
import ladder.domain.LadderMap;
import ladder.domain.Line;
import ladder.domain.Reward;
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
    }

    public static LadderController of() {
        return new LadderController();
    }

    public void climbLadder() {
        String userNames = inputView.userNamesReader();
        this.climber = Climber.of(userNames);

        String rewards = inputView.rewardReader();
        Reward reward = climber.offerPrize(rewards);

        int ladderHeight = inputView.ladderHeightReader();
        LadderMap ladderMap = climber.createLadder(ladderHeight);

        List<String> climberNameList = climber.getUserNames();
        List<List<Boolean>> ladderMapList = climber.getLadderMapList(ladderMap);
        List<String> rewardList = climber.getRewards(reward);

        outputView.printLadderResult(climberNameList, ladderMapList, rewardList);
    }
}
