package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class LadderTest {
    @DisplayName("사다리 생성 테스트")
    @Test
    void create_ladder() {
        assertThat(new Ladder(2, 3, () -> true).getLines())
                .hasSize(2);
    }

    @DisplayName("사다리 결과 생성 테스트")
    @Test
    void play_result() {
        assertThat(new Ladder(2, 3, () -> true).makeGameResult())
                .containsExactly(entry(0, 0), entry(1, 1), entry(2, 2));
    }
}
