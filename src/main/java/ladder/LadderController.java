package ladder;

import ladder.domain.Gamer;
import ladder.domain.Ladder;
import ladder.view.LadderView;

public class LadderController {
    public static void main(String[] args) {
        LadderView view = new LadderView();
        view.printGamerNameGuide();
        String name = view.getInput();
        Gamer gamer = Gamer.nameOf(name);

        view.printLadderHeightGuide();
        String height = view.getInput();
        Ladder ladder = Ladder.newLadder(gamer.getNames().size(), height);

        view.printRunResultGuide();
        view.printGamer(gamer);
        view.printLadder(ladder);
    }
}
