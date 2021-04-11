package nextstep.ladder.controller;

import nextstep.ladder.entity.Line;
import nextstep.ladder.entity.User;
import nextstep.ladder.util.StringUtil;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {
    public void start() {

        String userInput = InputView.user();
        int ladderHeight = InputView.ladderHeight();

        String[] userList = StringUtil.splitCommaByString(userInput);
        int userCount = userList.length;

        List<User> users = IntStream.range(0, userCount)
                .mapToObj(userIndex -> new User(userList[userIndex]))
                .collect(Collectors.toList());

        List<Line> lines = IntStream.range(0, userCount)
                .mapToObj(countOfPerson -> new Line(countOfPerson, ladderHeight))
                .collect(Collectors.toList());

        ResultView.printStart();
        ResultView.printUser(users);
        ResultView.printLadder(ladderHeight, lines);

    }
}
