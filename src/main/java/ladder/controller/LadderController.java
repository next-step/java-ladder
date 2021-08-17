package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.ladder.RandomLadderGenerator;
import ladder.domain.ladder.RandomLineGenerator;
import ladder.domain.player.PlayerNames;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private LadderController() {}

    public static void run() {
        String names = InputView.playerNames();
        PlayerNames playerNames = PlayerNames.of(names);
        int countOfPeople = playerNames.countOfPeople();

        int ladderHeight = InputView.ladderHeight();
        LadderGenerator ladderGenerator = new RandomLadderGenerator(new RandomLineGenerator());
        Ladder ladder = ladderGenerator.generate(ladderHeight, countOfPeople);
        ResultView.printResults(playerNames, ladder);
    }
}
