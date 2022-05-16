package ladder;

import ladder.domain.HorizontalLines;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        String names = InputView.inputParticipants();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        Players players = Players.create(names);
        ResultView.printResultPlayer(players.toString());

        Ladder ladder = new Ladder();
        List<HorizontalLines> horizontalLines = ladder.create(players.countOfPlayers(), maxLadderHeight);
        ResultView.printResult(horizontalLines);
    }
}
