import domain.LadderGame;
import ui.InputView;
import ui.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String names = InputView.askNames();
        int ladderHeight = InputView.askLadderHeight();

        LadderGame ladderGame = LadderGame.of(names, ladderHeight);

        ResultView.print(ladderGame);
    }
}
