package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.Users;
import ladder.service.PointGenerator;
import ladder.service.RandomPointGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        Users users = InputView.getUsers();
        LadderHeight ladderHeight = InputView.getLadderHeight();

        int countOfPerson = users.count();
        PointGenerator pointGenerator = new RandomPointGenerator();
        Ladder ladder = new Ladder(countOfPerson, ladderHeight, pointGenerator);

        ResultView.printLadderGenerationResult(users, ladder);
    }
}
