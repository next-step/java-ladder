package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGoalTest {

    @DisplayName("사다리 골 빈값일때 예외 발생 테스트")
    @Test
    public void ladderGoalIfEmptyExceptionTest() {
        assertThatThrownBy(() -> {
            LadderGoal ladderGoal = new LadderGoal("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 골 null 일때 예외 발생 테스트")
    @Test
    public void ladderGoalIfNullExceptionTest() {
        assertThatThrownBy(() -> {
            LadderGoal ladderGoal = new LadderGoal(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
