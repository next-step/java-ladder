package ladder;

import ladder.domain.*;
import ladder.ui.ConsoleInput;

public class Application {

    public static void main(String[] args) {
        PlayerGroup playerGroup = PlayerGroup.from(ConsoleInput.receiveNames());
        LadderHeight ladderHeight = new LadderHeight(ConsoleInput.receiveHeight());

        DefaultLinesGenerator defaultLinesGenerator = new DefaultLinesGenerator(playerGroup.findNumberOfPlayer(), ladderHeight, new RandomlyDetermineStick());
        Ladder ladder = new Ladder(defaultLinesGenerator);
    }
}
