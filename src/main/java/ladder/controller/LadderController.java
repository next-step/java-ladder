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

        Ladder ladder = new Ladder.Builder(users.size())
                .height(ladderHeight)
                .connectionMode(new RandomConnectionMode())
                .build();

        printGameStatus(users.exportData(), ladder.exportData(), rewards.exportData());

        Results results = ladder.generateResult(users, rewards);
        printRewardPerUser(results);
    }

    private void printGameStatus(UsersDTO usersDTO, LadderDTO ladderDTO, RewardsDTO rewardsDTO) {
        ResultView.printLadderLayoutOpening();
        ResultView.printUsers(usersDTO);
        ResultView.printLadder(ladderDTO);
        ResultView.printRewards(rewardsDTO);
    }

    private void printRewardPerUser(Results results) {
        while (true) {
            String request = InputView.askResult();
            ResultView.printRewardsOpening();
            processWithQuery(request, results);
        }
    }

    private void processWithQuery(String request, Results results) {
        if (request.equals(SEARCH_ALL_REQUEST)) {
            Map<String, String> response = results.responseForAll();
            ResultView.printAll(response);
            return;
        }

        String response = results.responseForOne(request);
        ResultView.printForOne(response);
    }
}
