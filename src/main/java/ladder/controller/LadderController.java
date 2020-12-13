package ladder.controller;

import ladder.domain.*;
import ladder.dto.LadderDTO;
import ladder.dto.RewardsDTO;
import ladder.dto.UsersDTO;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

import static ladder.domain.LadderConstant.SEARCH_ALL_REQUEST;

public class LadderController {

    public LadderController() {
    }

    public void run() {
        Users users = new Users(InputParser.parseRawInput(InputView.askNames()));
        Rewards rewards = new Rewards(InputParser.parseRawInput(InputView.askRewards()));
        int ladderHeight = InputView.askLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, users.size(), new RandomConnectionMode());

        printGameStatus(users.exportData(), ladder.exportData(), rewards.exportData());

        Result result = ladder.generateResult(users, rewards);
        printRewardPerUser(result);
    }

    private void printGameStatus(UsersDTO usersDTO, LadderDTO ladderDTO, RewardsDTO rewardsDTO) {
        ResultView.printLadderLayoutOpening();
        ResultView.printUsers(usersDTO);
        ResultView.printLadder(ladderDTO);
        ResultView.printRewards(rewardsDTO);
    }

    private void printRewardPerUser(Result result) {
        while (true) {
            String request = InputView.askResult();
            ResultView.printRewardsOpening();
            processWithQuery(request, result);
        }
    }

    private void processWithQuery(String request, Result result) {
        if (request.equals(SEARCH_ALL_REQUEST)) {
            Map<String, String> response = result.responseForAll();
            ResultView.printAll(response);
            return;
        }

        String response = result.responseForOne(request);
        ResultView.printForOne(response);
    }
}
