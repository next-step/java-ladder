package ladder.step2.domain.strategy;

import ladder.step2.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineCreateStrategyTest {
    @Nested
    @DisplayName("라인 생성 성공")
    class CreateLineSuccess {
        @RepeatedTest(100)
        void create_line_success() {
            Line line = new RandomLineCreateStrategy().createLine(5);
            assertThat(line).isNotNull();
        }
    }
}