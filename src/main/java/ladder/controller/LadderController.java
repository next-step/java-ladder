package ladder.controller;

import ladder.model.Result;
import ladder.model.ladder.Ladder;
import ladder.model.group.Rewards;
import ladder.model.group.Users;
import ladder.view.InputView;
import ladder.view.ResultView;


public class LadderController {
    private Users users;
    private Ladder ladder;
    private Rewards rewards;
    private Result result;

    public void run() {
        String usersInput = InputView.printInputUsersMessage();
        users = Users.from(usersInput);

        String rewardInput = InputView.printInputLadderResultMessage();
        String ladderSize = InputView.printInputLadderMessage();
        ladder = Ladder.of(ladderSize, users.size());
        rewards = Rewards.from(rewardInput, ladder.size());


        ResultView.printResult();
        ResultView.printNames(users.getNames());
        ResultView.printLadder(ladder.getLadder());
        ResultView.printNames(rewards.getNames());

        result = Result.of(ladder.getResults(users), rewards);
        String inputName;

        do{
            inputName = InputView.printInputSearchName();
            ResultView.printReward(result.getReward(inputName));
        }while (!inputName.equals("all"));
    }
}
