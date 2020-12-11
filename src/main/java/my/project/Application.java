package my.project;

import my.project.domain.Ladder;
import my.project.domain.Rewards;
import my.project.domain.Users;
import my.project.domain.Result;
import my.project.view.InputView;
import my.project.view.ResultView;

/**
 * Created : 2020-12-04 오전 8:51
 * Developer : Seo
 */
public class Application {
    public static void main(String[] args) {
        Users users = new Users(InputView.getUsers());
        Rewards rewards = new Rewards(users, InputView.getRewards());
        Ladder ladder = new Ladder(users, InputView.getLadderHeight());
        ResultView.print(users, ladder, rewards);

        Result result = new Result(users, ladder);
        ResultView.printResults(result.get(InputView.getUsername(), rewards));
    }
}
