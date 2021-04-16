package nextstep.ladder.controller;

import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;
import nextstep.ladder.entity.user.User;
import nextstep.ladder.entity.user.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    public void start() {

        String usersInput = InputView.user();
        String resultsInput = InputView.ladderResult();
        int ladderHeight = InputView.ladderHeight();

        Users users = new Users(usersInput);
        Ladder ladder = new Ladder(users.userCount(), ladderHeight);
        LadderResults ladderResults = new LadderResults(resultsInput);

        ResultView.printResult(users.userNames(), ladder);

        String resultMember = InputView.resultMember();

        List<Integer> startPositions = users.startPositions(resultMember);

        ResultView.gameResult(startPositions.size() == 1
                                ? singleResult(ladder, ladderResults, startPositions)
                                : multiResults(users, ladder, ladderResults, startPositions));

    }

    private List<String> singleResult(Ladder ladder, LadderResults ladderResults, List<Integer> startPositions) {
        return startPositions.stream()
                .map(startPosition -> ladderResults.positionResult(ladder.gameEndPosition(startPosition)))
                .collect(Collectors.toList());
    }

    private List<String> multiResults(Users users, Ladder ladder, LadderResults ladderResults, List<Integer> startPositions) {
        List<String> gameResults = new ArrayList<>();

        for (Integer startPosition : startPositions) {
            User user = users.startPositionUser(startPosition);
            String gameResult = ladderResults.positionResult(ladder.gameEndPosition(startPosition));
            gameResults.add(user.name() + " : " + gameResult);
        }

        return gameResults;
    }
}
