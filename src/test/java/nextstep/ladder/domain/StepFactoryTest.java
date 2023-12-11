package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StepFactoryTest {
    @DisplayName("이전 계단이 상태가 true라면 다음 계단은 무조건 false")
    @Test
    void 계단_생성() {
        StepFactory stepFactory = StepFactory.first(true);
        assertThat(stepFactory.next()).isFalse();
    }
}