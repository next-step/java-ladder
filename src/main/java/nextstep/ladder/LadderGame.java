package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
//        final List<String> names = InputView.inputNamesOfPlayer();
//        final int height = InputView.inputHeight();
        // easy test
        final List<String> names = List.of("name1", "name2", "name3", "name4", "name5", "name6");
        final int height = 6;
        final Players players = Players.of(names);
        final Ladder ladder = Ladder.of(players.count(), height);

        OutputView.printPlayerList(players.collect());
        OutputView.printLadder(ladder.ladder());
    }
}
