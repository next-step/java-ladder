package ladder;

import ladder.domain.*;
import ladder.ui.ConsoleInput;
import ladder.ui.ConsoleOutput;

public class Application {

    public static void main(String[] args) {
        PlayerGroup playerGroup = PlayerGroup.from(ConsoleInput.receiveNames());
        LadderHeight ladderHeight = new LadderHeight(ConsoleInput.receiveHeight());

        DefaultLinesGenerator defaultLinesGenerator = new DefaultLinesGenerator(playerGroup.findNumberOfPlayer(), ladderHeight, new RandomStickDecisionStrategy());
        Ladder ladder = new Ladder(defaultLinesGenerator);

        ConsoleOutput.printNamesAndLadder(playerGroup, ladder);
    }
}
