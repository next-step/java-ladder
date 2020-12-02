package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchesTest {

    Matches matches;

    @BeforeEach
    void setUp() {
        Map<Player, Result> playerResultMap = new HashMap<>();
        playerResultMap.put(new Player("a"), new Result("꽝"));
        playerResultMap.put(new Player("b"), new Result("5000"));
        matches = new Matches(playerResultMap);
    }

    @Test
    @DisplayName("player이름에 해당하는 result찾기")
    void find() {
        Result result = matches.find("a");

        assertThat(result).isEqualTo(new Result("꽝"));
    }

    @Test
    @DisplayName("없는 player이름에 해당하는 result찾기 시 에러")
    void find_noPlayer() {
        assertThatThrownBy(() -> {
            matches.find("c");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("there's no player of that name");
    }
}