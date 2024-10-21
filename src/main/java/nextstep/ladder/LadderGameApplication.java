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

        LadderGame ladderGame = new LadderGame(playerNames);
        Ladder ladder = ladderGame.makeLadder(height, new RandomLineGenerator());

        ResultView.printResultLetters();
        ResultView.printPlayers(ladderGame.getPlayers());
        ResultView.printLadder(ladder);

    }
}
