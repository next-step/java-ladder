package ladder;

import ladder.domain.LadderCreator;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultVIew;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Players players = new Players(InputView.askingPeopleName());
        int ladderHeight = InputView.askingLadderMaxHeight();

        List<String> peopleNames = players.getPlayerNames();
        LadderCreator ladderCreator = new LadderCreator(peopleNames.size(), ladderHeight);
        Ladder ladder = ladderCreator.createLadder();

        ResultVIew.printLadder(peopleNames, ladder.getLineList());
    }
}
