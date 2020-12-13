package my.project.step3;

import my.project.common.domain.Rewards;
import my.project.common.domain.Users;
import my.project.common.view.InputView;
import my.project.common.view.ResultView;
import my.project.step3.domain.Ladder;
import my.project.step3.domain.Result;

/**
 * Created : 2020-12-04 오전 8:51
 * Developer : Seo
 */
public class Step3Application {
    public static void main(String[] args) {
        Users users = new Users(InputView.getUsers());
        Rewards rewards = new Rewards(users, InputView.getRewards());
        Ladder ladder = new Ladder(users, InputView.getLadderHeight());
        //ResultView.print(users, ladder, rewards);

        Result result = new Result(users, ladder);
        ResultView.printResults(result.get(InputView.getUsername(), rewards));
    }
}
