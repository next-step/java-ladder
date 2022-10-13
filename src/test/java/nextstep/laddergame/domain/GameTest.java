package nextstep.laddergame.domain;

import nextstep.laddergame.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GameTest {
    private static List<Gamer> gamers = Arrays.asList(
            new Gamer("pobi")
            , new Gamer("honux")
            , new Gamer("crong")
            , new Gamer("jk")
    );
    private static Height height = new Height("5");

    @Test
    public void print_ladder() {
        Game game = new Game(gamers, height, DrawBridgeStrategy.DEFAULT_STRATEGY);
        ResultView.printLadder(game);
    }
}