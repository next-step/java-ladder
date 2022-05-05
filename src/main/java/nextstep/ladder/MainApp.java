package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.LadderGameCUI;

public class MainApp {

    public static void main(String[] args) {
        LadderGameCUI view = new LadderGameCUI();

        LadderGame game = new LadderGame(view.inputParticipants(), view.inputMaxLadderHeight());

        view.draw(game.createLadder());
    }

}
