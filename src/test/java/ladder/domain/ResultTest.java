package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultTest {
    @Test
    @DisplayName("주어진 player 이름에 알맞는 prize 이름을 반환한다")
    void player_이름으로_검색() {
        Result result = new Result();
        result.put(new Player("ayla"), new Prize("꽝"));
        assertThat(result.searchPlayer("ayla")).isEqualTo("꽝");
    }

    @Test
    @DisplayName("주어진 Player 이름이 존재하지 않는 이름이라면 예외를 던진다.")
    void 존재하지_않는_player_이름() {
        Result result = new Result();
        result.put(new Player("ayla"), new Prize("꽝"));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            result.searchPlayer("jenna");
        });
    }
}
