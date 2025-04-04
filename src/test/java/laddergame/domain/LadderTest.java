package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("사다리 생성 테스트")
    @Test
    void create_ladder() {
        assertThat(new Ladder(2, 3).getPoints())
                .hasSize(2);
    }
}
