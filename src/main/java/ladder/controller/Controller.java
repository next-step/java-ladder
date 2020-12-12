package ladder.controller;

import ladder.domain.*;
import ladder.dto.LadderDTO;
import ladder.dto.RewardsDTO;
import ladder.dto.UsersDTO;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Map;

import static ladder.domain.LadderConstant.SEARCH_ALL_REQUEST;

public class Controller {

    private Users users;
    private int ladderHeight;
    private Ladder ladder;
    private Rewards rewards;

    public Controller() {
    }

    public void run() {
        setUpUser();
        setUpRewards();
        setUpLadderHeight();
        generateLadder();
        printOpening();
        printUsers();
        printLadder();
        printRewards();
        printRewardPerUser();
    }

    private void setUpUser() {
        String userNameInput = InputView.askNames();
        List<String> parsedInput = InputParser.parseRawInput(userNameInput);
        users = new Users(parsedInput);
    }

    private void setUpRewards() {
        String RewardsInput = InputView.askRewards();
        List<String> parsedInput = InputParser.parseRawInput(RewardsInput);
        rewards = new Rewards(parsedInput);
    }

    private void setUpLadderHeight() {
        ladderHeight = InputView.askLadderHeight();
    }

    private void generateLadder() {
        ConnectionMode mode = new RandomConnectionMode();
        ladder = new Ladder(ladderHeight, users.size(), mode);
    }

    private void printOpening() {
        ResultView.printLadderLayoutOpening();
    }

    private void printUsers() {
        UsersDTO usersDTO = users.exportData();
        List<String> users = usersDTO.getUsers();
        ResultView.printUsers(users);
    }

    private void printLadder() {
        LadderDTO ladderDTO = ladder.exportData1();
        List<List<Boolean>> layout = ladderDTO.getLayout1();
        ResultView.printLadder(layout);
    }

    private void printRewards() {
        RewardsDTO rewardsDTO = rewards.exportData();
        List<String> rewards = rewardsDTO.getRewards();
        ResultView.printRewards(rewards);
    }

    private void printRewardPerUser() {
        Result result = ladder.generateResult(users, rewards);
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
