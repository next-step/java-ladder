package nextstep.step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMoveImplTest {

    @Test
    @DisplayName("이전 값이 true일 경우 false")
    void setFalse() {
        MoveStrategy moveStrategy = new RandomMoveImpl();
        Assertions.assertThat(moveStrategy.move(true)).isEqualTo(false);
    }

}