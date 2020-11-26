import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import domain.PlayerNames;
import ui.InputView;
import ui.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        String names = InputView.askNames();
        int ladderHeight = InputView.askLadderHeight();

        LadderGame ladderGame = LadderGame.of(names, ladderHeight);

        ResultView.print(ladderGame);
    }
}
