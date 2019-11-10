package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.view.InputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> users = InputView.createUsers();
        int ladderHeight = InputView.createLadderHeight();

        LadderGame game = new LadderGame();
        Ladder ladder = game.createLadder(users, ladderHeight);
    }
}
