package step2.controller;

import step2.model.Ladder;
import step2.model.RandomLadderStrategy;
import step2.model.Results;
import step2.model.Users;

import static step2.view.InputView.*;
import static step2.view.ResultView.*;

public class LadderGame {
    public static void main(String[] args) {
        String userName = ask("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Users users = new Users(userName);
        int numberOfUsers = users.getNumberOfUsers();

        String gameResults = ask("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Results results = new Results(gameResults, numberOfUsers);

        String high = ask("최대 사다리 높이는 몇 인가요?");

        Ladder ladder = new Ladder(high, numberOfUsers, new RandomLadderStrategy());

        printResult(users.getName());
        printLadder(ladder.getLadder());
        printResult(results.getResults());
    }
}
