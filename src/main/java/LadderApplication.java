import domain.LadderGame;
import view.InputView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<String> participantNames = InputView.inputParticipantNames();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        LadderGame game = new LadderGame(participantNames, maxLadderHeight);
        game.play();
    }
}
