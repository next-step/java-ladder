package nextstep.ladder;

import static nextstep.ladder.view.InputView.inputLadderHeight;
import static nextstep.ladder.view.InputView.inputNames;
import static nextstep.ladder.view.ResultView.printLadder;
import static nextstep.ladder.view.ResultView.printPlayerNames;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Players players = new Players(inputNames(ResultView::printInputName));
        int height = inputLadderHeight(ResultView::printInputHeight);

        Ladder ladder = new Ladder(height, players.getPlayerCount());

        printPlayerNames(players);

        printLadder(ladder);
    }
}
