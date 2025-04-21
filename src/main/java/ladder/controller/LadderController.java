package ladder.controller;

import ladder.domain.*;
import ladder.service.PointGenerator;
import ladder.service.RandomPointGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderController {
    public static void main(String[] args) {
        Ladder ladder = generateLadder();

        while (true) {
            findLadderResult(ladder);
        }
    }

    private static Ladder generateLadder() {
        Users users = InputView.getUsers();
        Results results = InputView.getResults();
        LadderHeight ladderHeight = InputView.getLadderHeight();
        PointGenerator pointGenerator = new RandomPointGenerator();
        Ladder ladder = new Ladder(users, results, ladderHeight, pointGenerator);
        ResultView.printLadderGenerationResult(ladder);
        return ladder;
    }

    private static void findLadderResult(Ladder ladder) {
        User targetUser = InputView.getTargetUser();
        if (targetUser.getName().equals("all")) {
            Map<User, Result> results = ladder.findResultAll();
            ResultView.printFindResults(results);
        }
        else {
            Result result = ladder.findResult(targetUser);
            ResultView.printFindResult(result);
        }
    }
}
