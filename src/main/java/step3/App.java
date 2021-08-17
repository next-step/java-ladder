package step3;

import step3.domain.game.Game;
import step3.inputView.InputView;
import step3.outputView.OutputView;

import java.util.Collections;

public class App {
    private static final String ALL = "all";

    public static void main(String[] args) {
        Game game = Game.initGame();
        game.showMap();

        while (true) {
            String nameOf = InputView.getNameOf();

            if (nameOf.equals(ALL)) {
                game.findResultAll();
                return;
            }

            game.findResultOf(Collections.singletonList(nameOf));
        }
    }
}
