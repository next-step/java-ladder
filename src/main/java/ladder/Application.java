package ladder;

import ladder.model.Ladder;
import ladder.model.Layer;
import ladder.model.Player;
import ladder.util.RandomRungGenerator;
import ladder.util.RungGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Player> players = InputView.askPlayers();

        int height = InputView.askHeight();

        Ladder ladder = Ladder.of(players.size(), height);

        OutputView.print(players, ladder);
    }
}
