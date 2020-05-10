package ladder.controller;


import ladder.domain.*;
import ladder.dto.UserStatusDto;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderController {

    private static final String VIEW_USERS_ALL_RESULT_COMMAND = "all";

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
        int ladderHeight = inputView.ladderHeightReader();

        CrossRoadStrategy halfPercentCreate = () -> new Random().nextInt(10) >= 5;
        this.climber = Climber.of(userNames, ladderHeight, halfPercentCreate);
        Reward reward = climber.offerPrize(rewards);

        LadderMap ladderMap = climber.targetLadder();

        List<String> climberNameList = climber.participantNames();
        List<List<Boolean>> ladderMapList = climber.getLadderMapList(ladderMap);
        List<String> rewardList = climber.getRewards(reward);

        outputView.printLadderResult(climberNameList, ladderMapList, rewardList);

        inquiryEachUserName(reward);

        List<UserStatusDto> userStatusDtos = claimAll(climberNameList, reward);
        outputView.resultAllUser(userStatusDtos);
    }

    private void inquiryEachUserName(Reward reward) {
        String userName = inputView.userNameReader();
        if(userName.equals(VIEW_USERS_ALL_RESULT_COMMAND)) {
            return;
        }
        int position = climber.climbByUser(userName);
        UserStatusDto userStatusDto = userGameResult(userName, reward, position);
        outputView.resultEachUser(userStatusDto);

        inquiryEachUserName(reward);
     }

    public List<UserStatusDto> claimAll(List<String> climberNameList, Reward reward) {
        List<UserStatusDto> userStatusDtos = new ArrayList<>();
        for (String userName : climberNameList) {
            int position = climber.climbByUser(userName);
            userStatusDtos.add(userGameResult(userName, reward, position));
        }
        return userStatusDtos;
    }

    private UserStatusDto userGameResult(String name, Reward reward, int position) {
        String prize = reward.prizeByEachPosition(position);
        return new UserStatusDto(name, prize);
    }
}
