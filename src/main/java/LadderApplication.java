import domain.LadderGame;
import domain.Length;
import domain.PlayerNames;
import ui.InputView;
import ui.ResultView;

public class LadderApplication {
    public static void main(String[] args) throws Exception {
        String names = InputView.askNames();
        int ladderHeight = InputView.askLadderHeight();

        PlayerNames playerNames = PlayerNames.of(names);
        Length height = Length.of(ladderHeight);

        LadderGame ladderGame = LadderGame.of(playerNames, height);

        ResultView.print(ladderGame);
    }
}
