package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        String names = InputView.inputParticipants();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        Players players = Players.create(names);
        ResultView.printResultPlayer(players);

        ConnectingStrategy connectingStrategy = new RandomConnectingStrategy();
        List<HorizontalLines> horizontalLines = Ladder.create(players.countOfPlayers(), maxLadderHeight, connectingStrategy);
        ResultView.printResult(horizontalLines);
    }
}
