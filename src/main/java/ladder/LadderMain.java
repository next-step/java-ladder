package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        String names = InputView.inputParticipants();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        Players players = new Players(names);
        ResultView.printResultPlayer(players);

        ConnectingStrategy connectingStrategy = new RandomConnectingStrategy();
        Ladder ladder = new Ladder(players.countOfPlayers(), maxLadderHeight, connectingStrategy);
        ResultView.printResult(ladder.getVerticalLines());
    }
}
