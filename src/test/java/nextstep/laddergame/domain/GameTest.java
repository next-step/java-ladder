package nextstep.laddergame.domain;

import nextstep.laddergame.view.ResultView;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GameTest {
    private static List<Gamer> gamers = Arrays.asList(
            new Gamer("pobi", 0)
            , new Gamer("honux", 1)
            , new Gamer("crong", 2)
            , new Gamer("jk", 3)
    );
    private static Height height = new Height("5");

    @Test
    public void print_ladder() {
        Game game = new Game(gamers, height, DrawBridgeStrategy.DEFAULT_STRATEGY);
        ResultView.printLadder(game);
    }

    @RepeatedTest(10)
    void getResultIndex() {
        Game game = new Game(gamers, height, DrawBridgeStrategy.DEFAULT_STRATEGY);
        List<Integer> resultAll = game.getResultAll();

        ResultView.printLadder(game);
        System.out.println(resultAll.toString());
    }
}