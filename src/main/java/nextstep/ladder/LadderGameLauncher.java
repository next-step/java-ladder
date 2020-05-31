package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameLauncher {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private void play() {
        List<String> playerNames = inputView.requestPlayers();
        int height = inputView.requestHeight();

        Ladder ladder = Ladder.of(height, playerNames);

        outputView.printResult(ladder.getPlayers(), ladder.getLines());
    }

    public static void main(String[] args) {
        new LadderGameLauncher().play();
    }
}
