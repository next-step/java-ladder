package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {

        final List<String> playerNames = InputView.getPlayerNames();
        final int rowCount = InputView.getRowCount();

        Ladder ladder = new Ladder(playerNames, rowCount);
        OutputView.printDrawResult(ladder);
    }
}
