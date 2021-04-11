package nextstep.ladder.controller;

import nextstep.ladder.entity.Line;
import nextstep.ladder.entity.User;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {

        String userInput = inputView.user();
        int ladderHeight = inputView.ladderHeight();

        String[] userList = userInput.split(",");
        int userCount = userList.length;

        List<User> users = IntStream.range(0, userCount)
                .mapToObj(userIndex -> new User(userList[userIndex]))
                .collect(Collectors.toList());

        List<Line> lines = IntStream.range(0, userCount)
                .mapToObj(countOfPerson -> new Line(countOfPerson, ladderHeight))
                .collect(Collectors.toList());

        resultView.printStart();
        resultView.printUser(users);
        resultView.printLadder(ladderHeight, lines);

    }
}
