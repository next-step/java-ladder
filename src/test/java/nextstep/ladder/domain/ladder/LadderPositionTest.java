package nextstep.ladder.domain.ladder;

import nextstep.ladder.exception.OutOfRangeArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 타기시 위치를 표현하기 위한 클래스")
class LadderPositionTest {

    @DisplayName("사다리 위치는 숫자값을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(LadderPosition.from(5)).isInstanceOf(LadderPosition.class);
    }


    @DisplayName("사다리 위치는 음수가 될 수 없으며, 음수값이 들어올 경우 예외를 던진다")
    @Test
    void initException() {
        assertThatThrownBy(() -> LadderPosition.from(-1)).isInstanceOf(OutOfRangeArgumentException.class);
    }
}
