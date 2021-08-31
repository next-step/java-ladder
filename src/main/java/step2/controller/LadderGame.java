package step2.controller;

import step2.model.Ladder;
import step2.model.RandomLadderStrategy;
import step2.model.Users;

import static step2.view.InputView.*;
import static step2.view.ResultView.*;

public class LadderGame {
    public static void main(String[] args) {
        String userName = ask("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String high = ask("최대 사다리 높이는 몇 인가요?");

        Users users = new Users(userName);
        int numberOfUsers = users.getNumberOfUsers();

        Ladder ladder = new Ladder(high, numberOfUsers, new RandomLadderStrategy());

        printUserName(users.getName());
        printLadder(ladder.getLadder());
    }
}
