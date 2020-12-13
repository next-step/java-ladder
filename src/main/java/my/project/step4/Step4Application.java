package my.project.step4;

import my.project.step4.domain.Ladder;
import my.project.step4.domain.Result;
import my.project.common.domain.Rewards;
import my.project.common.domain.Users;
import my.project.common.view.InputView;
import my.project.common.view.ResultView;

/**
 * Created : 2020-12-04 오전 8:51
 * Developer : Seo
 */
public class Step4Application {
    public static void main(String[] args) {
        Users users = new Users(InputView.getUsers());
        Rewards rewards = new Rewards(users, InputView.getRewards());
        Ladder ladder = new Ladder(users, InputView.getLadderHeight());
        ResultView.print(users, ladder, rewards);

        Result result = new Result(users, ladder);
        ResultView.printResults(result.get(InputView.getUsername(), rewards));
    }
}
