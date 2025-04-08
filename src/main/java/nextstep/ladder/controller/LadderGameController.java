package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LadderGameController {

    public static void main(String[] args) {
        List<String> participantNames = InputView.inputParticipantNames();
        List<String> rewardNames = InputView.inputRewardNames();
        GameEntities gameEntities = GameEntities.from(participantNames, rewardNames);

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.createRandomLadder(ladderHeight, gameEntities.size(), new Random());

        ResultView.printResult(gameEntities, ladder);

        LadderGame ladderGame = new LadderGame(gameEntities, ladder);

        while (true) {
            String participantName = InputView.inputParticipantName();
            if (!participantName.equals("all")) {
                Reward reward = ladderGame.findRewardByParticipantName(participantName);
                ResultView.printReward(reward);
            } else {
                LadderGameResults ladderGameResults = ladderGame.findAllResult();
                ResultView.printAllResult(ladderGameResults);
                break;
            }
        }
    }
}
