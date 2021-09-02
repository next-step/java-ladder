package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {
    @Test
    public void 게임_결과() {
        //given
        Users users = new Users("user1, user2, user3, user4");
        Results results1 = new Results("꽝, 5000, 꽝, 2000", 4);
        GameResults actual = new GameResults(users, results1);

        Ladder ladder = new Ladder("5", 4, () -> true);

        Results results2 = new Results("5000, 꽝, 2000, 꽝", 4);
        GameResults expect = new GameResults(users, results2);

        //when
        GameResults actualResult = ladder.runGame(actual);

        //then
        assertThat(actualResult).isEqualTo(expect);
    }
}
