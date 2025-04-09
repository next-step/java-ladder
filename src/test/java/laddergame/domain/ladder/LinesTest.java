package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @DisplayName("모든 행 통과한 결과 테스트")
    @Test
    void play_result() {
        assertThat(new Lines(2, 3, () -> true).goDownToEnd(0))
                .isEqualTo(0);
    }
}
