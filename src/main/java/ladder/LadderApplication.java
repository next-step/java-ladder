package ladder;

import ladder.dto.Line;

import java.util.ArrayList;
import java.util.List;

import static ladder.view.InputView.getLadderHeight;
import static ladder.view.InputView.getPlayerNames;
import static ladder.view.ResultView.*;

public class LadderApplication {

    public static void main(String[] args) {
        List<String> playerNames = getPlayerNames();
        int ladderHeight = getLadderHeight();
        List<Line> ladder = makeLadder(ladderHeight, playerNames.size());

        viewResult();
        viewPlayerNames(playerNames);
        viewLadder(playerNames, ladder);
    }

    private static List<Line> makeLadder(int ladderHeight, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(countOfPerson));
        }
        return ladder;
    }

}
