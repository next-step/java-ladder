package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        InputUsers inputUsers = new InputUsers(inputView.inputParticipants());
        Users users = Users.createUsers(inputUsers);

        int usersNumber = users.getUsers().size();
        InputResult inputResult = InputResult.createInputResult(inputView.inputResults(), usersNumber);
        Results results = Results.createResults(inputResult);

        Height height = new Height(Integer.parseInt(inputView.inputHeight()));

        Map<User, Integer> userMap = users.mapUserIndex();

        resultView.printResultMention();
        resultView.printUsers(users);
        Ladder ladder = Ladder.initLadder(users, height);
        resultView.drawLadders(ladder);
    }
}
