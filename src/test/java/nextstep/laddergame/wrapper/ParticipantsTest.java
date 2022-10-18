package nextstep.laddergame.wrapper;

import nextstep.laddergame.domain.DrawBridgeStrategy;
import nextstep.laddergame.domain.Game;
import nextstep.laddergame.domain.Gamer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {
    private static String POBI = "pobi";
    private static int POBI_INDEX = 0;
    private static Participants gamers = new Participants(Arrays.asList(
            new Gamer(POBI, POBI_INDEX)
            , new Gamer("honux", 1)
            , new Gamer("crong", 2)
            , new Gamer("jk", 3)
    ));
    private static Height height = new Height("5");
    private static Game game = new Game(gamers, height, DrawBridgeStrategy.DEFAULT_STRATEGY);


    @Test
    void getNumberOfPersonTest() {
        assertThat(gamers.getNumberOfPerson()).isEqualTo(game.getGamers().size());
    }

    @Test
    void getGamerTest1() {
        assertThat(gamers.getGamer(POBI_INDEX).getIndex()).isEqualTo(POBI_INDEX);
        assertThat(gamers.getGamer(POBI_INDEX).getName()).isEqualTo(POBI);
    }

    @Test
    void getGamerTest2() {
        assertThat(gamers.getGamer(POBI).getIndex()).isEqualTo(POBI_INDEX);
        assertThat(gamers.getGamer(POBI).getName()).isEqualTo(POBI);
    }
}