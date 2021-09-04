package step2.controller;

import step2.model.*;

import java.util.LinkedHashMap;

import static step2.view.InputView.*;
import static step2.view.ResultView.*;

public class LadderGame {
    public static void main(String[] args) {
        String userName = ask("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Users users = new Users(userName);
        int numberOfUsers = users.getNumberOfUsers();

        String ladderResults = ask("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Results results = new Results(ladderResults, numberOfUsers);

        String high = ask("최대 사다리 높이는 몇 인가요?");

        Ladder ladder = new Ladder(high, numberOfUsers, new RandomLadderStrategy());
        GameResults gameResults = ladder.runGame(Integer.parseInt(high), numberOfUsers, users, results);

        printResult(users.getNameList());
        printLadder(ladder.getLadder());
        printResult(results.getResultList());

        userName = ask("결과를 보고 싶은 사람은?");

        LinkedHashMap<String, String> stringStringMap = gameResults.allUsersResults();
        printUserResult(userName, stringStringMap);
    }
}
