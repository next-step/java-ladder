package ladder;

import ladder.domain.LadderHeight;
import ladder.domain.PlayerGroup;
import ladder.ui.ConsoleInput;

public class Application {

    public static void main(String[] args) {
        PlayerGroup playerGroup = PlayerGroup.from(ConsoleInput.receiveNames());
        LadderHeight ladderHeight = new LadderHeight(ConsoleInput.receiveHeight());
    }
}
