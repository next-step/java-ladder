package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;

import static nextstep.ladder.view.InputView.inputLadderHeight;
import static nextstep.ladder.view.InputView.inputNames;
import static nextstep.ladder.view.ResultView.printLadder;
import static nextstep.ladder.view.ResultView.printPlayerNames;

public class Application {
    public static void main(String[] args) {
        Players players = new Players(inputNames());
        int height = inputLadderHeight();

        Ladder ladder = Ladder.create(height, players.getPlayerCount());

        printPlayerNames(players);

        printLadder(ladder);
    }
}
