package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.line.RandomLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        final List<String> names = InputView.inputNamesOfPlayer();
        final int height = InputView.inputHeight();
        final Players players = Players.of(names);
        final Ladder ladder = Ladder.of(players.count(), height, new RandomLineStrategy());

        OutputView.printPlayerList(players);
        OutputView.printLadder(ladder);
    }
}
