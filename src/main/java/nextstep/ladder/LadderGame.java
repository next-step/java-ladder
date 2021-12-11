package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        final List<String> names = InputView.inputNamesOfPlayer();
        final int height = InputView.inputHeight();
        Ladder ladder = Ladder.of(names, height);

        OutputView.printPlayerList(ladder.playerList());
        OutputView.printLadder(ladder.ladder());
    }
}
