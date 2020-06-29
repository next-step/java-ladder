package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameResultTest {


    @Test
    public void gameResult() {

        //given
        List<User> users = new ArrayList<>();
        users.add(new User("a", 0));
        users.add(new User("b", 1));
        Results results = new Results(new String[]{"1000", "0"});

        //when
        GameResult gameResult = new GameResult(users, results);

        //then
        assertThat(gameResult.toStringList("all"))
            .hasSize(2)
            .isEqualTo(Arrays.asList("a : 1000", "b : 0"));
        assertThat(gameResult.toStringList("a"))
            .hasSize(1)
            .isEqualTo(Arrays.asList("1000"));
        assertThat(gameResult.toStringList("b"))
            .hasSize(1)
            .isEqualTo(Arrays.asList("0"));

    }
}