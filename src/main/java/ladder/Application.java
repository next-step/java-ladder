package ladder;

import ladder.model.Layer;
import ladder.model.Player;
import ladder.util.RungGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Player> players = InputView.askPlayers();

        int height = InputView.askHeight();

        for(int i = 0; i < height; i++) {
            Layer layer = new Layer(RungGenerator.generate(players.size() - 1));

            OutputView.print(layer);
        }
    }
}
