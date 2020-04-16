package ladder.controller;


import ladder.domain.*;
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

        String rewards = inputView.rewardReader();
        Reward reward = climber.offerPrize(rewards);

        int ladderHeight = inputView.ladderHeightReader();
        this.climber = Climber.of(userNames, ladderHeight);

        LadderMap ladderMap = climber.targetLadder();

        List<String> climberNameList = climber.participantNames();
        List<List<Boolean>> ladderMapList = climber.getLadderMapList(ladderMap);
        List<String> rewardList = climber.getRewards(reward);

        outputView.printLadderResult(climberNameList, ladderMapList, rewardList);

        while (true) {
            String userName = inputView.userNamesReader();

            if (userName.equals("all"))  {

            }
        }
    }
}
