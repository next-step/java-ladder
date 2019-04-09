package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {

        String inputPlayerNames = InputView.getInputPlayerNames();

        int inputLadderHeight = InputView.getInputLadderHeight();

        LadderPlayers players = LadderPlayers.createPlayers(inputPlayerNames);

        Ladder ladder = new Ladder(inputLadderHeight, players.size());
        OutputView.printPlayer(players);
        OutputView.printLadders(ladder);

    }

}
