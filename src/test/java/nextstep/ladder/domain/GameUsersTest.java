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
        Map<String, String> resultMap = gameUsers.getGameResult(new String[]{"3","2","1"});

        //then
        assertThat(resultMap.get("a")).isEqualTo("3");
        assertThat(resultMap.get("b")).isEqualTo("2");
        assertThat(resultMap.get("c")).isEqualTo("1");
    }
}