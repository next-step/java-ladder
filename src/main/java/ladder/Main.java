package ladder;

import ladder.domain.LineList;
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
        Ladder ladder = new Ladder(peopleNames.size(), ladderHeight);
        LineList lineList = ladder.createLadder();

        ResultVIew.printLadder(peopleNames, lineList.getLineList());
    }
}
