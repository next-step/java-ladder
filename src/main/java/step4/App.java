package step4;

import step4.domain.game.Game;
import step4.inputView.InputView;

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
