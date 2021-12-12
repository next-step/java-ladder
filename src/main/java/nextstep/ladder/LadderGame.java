package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.line.RandomLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        //final List<String> names = InputView.inputNamesOfPlayer();
        //final int height = InputView.inputHeight();
        // for easy test
        final List<String> names = List.of("n1", "n2", "n3", "n4", "n5");
        final int height = 10;
        final List<String> resultList = List.of("r1", "r2", "r3", "r4", "r5");
        final Players players = Players.of(names);
        final Results results = Results.of(resultList);
        final Ladder ladder = Ladder.of(players.count(), height, new RandomLineStrategy());

        OutputView.printPlayerList(players);
        OutputView.printLadder(ladder);
    }
}
