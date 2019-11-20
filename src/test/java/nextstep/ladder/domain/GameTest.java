package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void 생성_실패_사다리높이_문제(int totalStep) {
        Spots spots = new Spots("aa,bb,cc", "0,500,1000");
        assertThatThrownBy(() -> {
            new Game(spots, totalStep);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 중복없는결과() {
        Spots spots = new Spots("aa,bb,cc", "0,500,1000");
        Game game = new Game(spots, 4);
        Map<String, String> result = game.execute();
        assertThat(result.containsValue("0"));
        assertThat(result.containsValue("500"));
        assertThat(result.containsValue("1000"));
    }

}