package ladder;

import ladder.model.Ladder;
import ladder.model.Layer;
import ladder.model.Player;
import ladder.util.RungGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Player> players = InputView.askPlayers();

        int height = InputView.askHeight();

        RungGenerator rungGenerator = new RungGenerator();

        List<Layer> layers = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            layers.add(new Layer(rungGenerator.generate(players.size() - 1)));
        }

        OutputView.print(players, layers);
    }
}
