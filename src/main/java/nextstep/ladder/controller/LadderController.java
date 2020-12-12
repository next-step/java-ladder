package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderController {

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        GameCriteria gameCriteria = inputView.getGameCriteria();

        Users users = gameCriteria.getUsers();
        Height height = gameCriteria.getHeight();
        Results results = gameCriteria.getResult();

        Ladder ladder = Ladder.initLadder(users, height);

        List<User> userList = users.getUsers();
        Map<String, Result> userResultMap = mapUsernameResult(results, ladder, userList);

        resultView.printResultMention();
        resultView.printUsers(users);

        resultView.drawLadders(ladder);

        resultView.printResult(userResultMap, inputView.inputResultUser());
    }

    private Map<String, Result> mapUsernameResult(Results results, Ladder ladder, List<User> userList) {
        return userList.stream()
                    .collect(Collectors.toMap(User::getName,
                            getUserResult(results, ladder),
                            (participant1, participant2) -> participant1,
                            LinkedHashMap::new));
    }

    private Function<User, Result> getUserResult(Results results, Ladder ladder) {
        return user -> {
            int finalIndex = ladder.getUserFinalIndex(user);
            return results.confirmResult(finalIndex);
        };
    }
}
