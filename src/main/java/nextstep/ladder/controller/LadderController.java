package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderController {

    private final int ZERO = 0;

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
        Map<Result, Integer> resultMap = results.mapResultIndex();

        resultView.printResultMention();
        resultView.printUsers(users);
        Ladder ladder = Ladder.initLadder(users, height);
        Map<User, Integer> endMap = ladder.matchLadder(userMap);

        resultView.drawLadders(ladder);

        Map<User, Result> userResultMap = matchResults(endMap, resultMap);
    }

    public Map<User, Result> matchResults(Map<User, Integer> endMap, Map<Result, Integer> resultMap) {
        Map<User, Result> answerMap = new HashMap<>();

        Map<Integer, User> newEndMap = reverseEnd(endMap);
        Map<Integer, Result> newResultMap = reverseResult(resultMap);

        IntStream.range(ZERO, endMap.size())
                .forEach(index -> answerMap.put(newEndMap.get(index), newResultMap.get(index)));

        return answerMap;
    }

    private Map<Integer, User> reverseEnd(Map<User, Integer> endMap) {
        Map<Integer, User> newEndMap = new HashMap<>();
        endMap.keySet()
                .forEach(key -> newEndMap.put(endMap.get(key), key));
        return newEndMap;
    }

    private Map<Integer, Result> reverseResult(Map<Result, Integer> resultMap) {
        Map<Integer, Result> newResultMap = new HashMap<>();
        resultMap.keySet()
                .forEach(key -> newResultMap.put(resultMap.get(key), key));

        return newResultMap;
    }
}
