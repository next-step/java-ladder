package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderGame;
import nextstep.ladder.model.RandomLineGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayers();
        int height = InputView.inputLadderHeight();
        LadderGame ladderGame = new LadderGame(playerNames, height);
        Ladder ladder = ladderGame.run(new RandomLineGenerator());
        System.out.println("height: " + ladder.getHeight());
        ladder.getLines().forEach(System.out::println);
        ResultView.printLadder(ladder, ladderGame.getPlayers());
    }
}
