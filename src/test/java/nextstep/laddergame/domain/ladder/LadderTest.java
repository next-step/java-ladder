package nextstep.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThat(new Ladder(5, 3))
                .extracting("lines")
                .asList()
                .hasSize(5);
    }

    @Test
    @DisplayName("사다리 높이가 0일경우 exception 발생")
    void zeroLadderHeight() {
        assertThatThrownBy(() -> new Ladder(0, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
