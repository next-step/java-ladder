package my.project;

import my.project.domain.Ladder;
import my.project.dto.Result;
import my.project.domain.Rewards;
import my.project.domain.Users;
import my.project.view.InputView;
import my.project.view.ResultView;

import java.util.List;

/**
 * Created : 2020-12-04 오전 8:51
 * Developer : Seo
 */
public class Application {
    public static void main(String[] args) {
        Users users = new Users(InputView.getUsers());
        Rewards rewards = new Rewards(InputView.getRewards(), users);
        Ladder ladder = new Ladder(users, InputView.getLadderHeight());
        ResultView.print(users, ladder, rewards);

        List<Result> resultList = ladder.results(InputView.getUsername(), rewards);
        ResultView.printResults(resultList);
    }
}
