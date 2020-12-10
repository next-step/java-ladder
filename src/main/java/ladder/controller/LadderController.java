package ladder.controller;

import ladder.model.Result;
import ladder.model.ladder.Ladder;
import ladder.model.group.Rewards;
import ladder.model.group.Users;
import ladder.view.InputView;
import ladder.view.ResultView;


public class LadderController {
    public void run() {
        String usersInput = InputView.printInputUsersMessage();
        Users users = Users.from(usersInput);

        String rewardInput = InputView.printInputLadderResultMessage();
        String ladderSize = InputView.printInputLadderMessage();
        Ladder ladder = Ladder.of(ladderSize, users.size());
        Rewards rewards = Rewards.from(rewardInput);

        ResultView.printResult();
        ResultView.printNames(users.getNames());
        ResultView.printLadder(ladder.getLadder());
        ResultView.printNames(rewards.getNames());

        Result result = Result.of(ladder.getResults(users.getUserNames()), rewards);
        String inputName;

        do{
            inputName = InputView.printInputSearchName();
            ResultView.printReward(result.getReward(inputName));
        }while (!inputName.equals("all"));
    }
}
