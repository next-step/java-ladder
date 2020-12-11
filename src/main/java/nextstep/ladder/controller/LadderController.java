package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderController {

    private final int ZERO = 0;

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        GameCriteria gameCriteria = inputView.getGameCriteria();

        Users users = gameCriteria.getUsers();
        Height height = gameCriteria.getHeight();
        Results results = gameCriteria.getResult();

        Ladder ladder = Ladder.initLadder(users, height);

        List<User> userList = users.getUsers();
        Map<String, Result> userResultMap = userList.stream()
                .collect(Collectors.toMap(User::getName,
                        user -> {
                            int finalIndex = ladder.getUserFinalIndex(user);
                            return results.confirmResult(finalIndex);
                        },
                        (participant1, participant2) -> participant1,
                        LinkedHashMap::new));

        resultView.printResultMention();
        resultView.printUsers(users);

        resultView.drawLadders(ladder);

        resultView.printResult(userResultMap, inputView.inputResultUser());
    }
}
