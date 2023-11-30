package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StepTest {
    @DisplayName("이전 계단이 상태가 true라면 다음 계단은 무조건 false")
    @Test
    void 계단_생성() {
        Step step = new Step(true);
        assertThat(step.next()).isFalse();
    }
}