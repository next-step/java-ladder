package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GameUsersTest {

    @Test
    void getGameResult() {
        //given
        GameUsers gameUsers = new GameUsers(new String[]{"a", "b", "c"});

        //when
        GameResult gameResult = gameUsers.getGameResult(new Results(new String[]{"3","2","1"}));

        //then
        assertThat(gameResult.toStringList("all"))
            .isEqualTo(Arrays.asList(new String[]{"a : 3", "b : 2", "c : 1"}));
    }
}