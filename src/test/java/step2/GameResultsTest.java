package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {
    @Test
    public void 게임_결과() {
        //given
        int numberOfUser = 4;
        int high = 5;
        Users users = new Users("user1, user2, user3, user4");
        Results results1 = new Results("꽝, 5000, 꽝, 2000", numberOfUser);

        Ladder ladder = new Ladder("5", numberOfUser, () -> true);

        Results results2 = new Results("5000, 꽝, 2000, 꽝", numberOfUser);
        GameResults expect = new GameResults(users, results2);

        //when
        GameResults actualResult = ladder.runGame(high, numberOfUser, users, results1);

        //then
        assertThat(actualResult).isEqualTo(expect);
    }
}
