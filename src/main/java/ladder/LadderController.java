package ladder;

import ladder.domain.Gamer;
import ladder.domain.Ladder;
import ladder.view.LadderView;

public class LadderController {
    public static void main(String[] args) {
        LadderView view = new LadderView();
        view.printGamerNameGuide();
        String names = view.getInput();
        Gamer gamer = new Gamer(names);

        view.printLadderHeightGuide();
        String height = view.getInput();
        Ladder ladder = new Ladder(gamer.getNames().size(), height);

        view.printRunResultGuide();
        view.printGamer(gamer);
        view.printLadder(ladder);
    }
}
