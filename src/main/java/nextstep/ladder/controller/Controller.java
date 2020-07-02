package nextstep.ladder.controller;

import nextstep.ladder.StringParser;
import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Rewards;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputNames();
        inputView.inputReward();
        inputView.inputHeight();

        Users users = new Users(inputView.getUserNames());
        Ladder ladder = new Ladder(StringParser.toInteger(inputView.getLadderHeight()), users.getCount());
        List<String> rewardsString = StringParser.splits(inputView.getReward());
        Rewards rewards = new Rewards(rewardsString);

        ResultView resultView = new ResultView();
        resultView.printLadder(users.getNames(), ladder.getLines(), rewardsString);

        GameResult gameResult = new GameResult(ladder.play(users, rewards));

        inputView.inputRewardTarget();

        resultView.printResult(inputView.getResultTarget(), gameResult);
    }
}
