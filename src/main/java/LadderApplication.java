import domain.LadderGame;
import view.InputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderGame game = new LadderGame(InputView.inputParticipantNames(), InputView.inputMaxLadderHeight());
        game.play();

    }
}
