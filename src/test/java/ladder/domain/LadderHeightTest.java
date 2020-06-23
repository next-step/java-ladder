package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @DisplayName("정상적으로 객체가 생성되고 height 값을 얻어 올 수 있는 지 확인")
    @Test
    void getTest() {
        LadderHeight ladderHeight = LadderHeight.of(5);

        assertThat(ladderHeight.get()).isEqualTo(5);
    }

    @DisplayName("최소 높이 이하로 입력될 경우 IllegalArgument 예외가 발생한다.")
    @Test
    void validateMinHeight() {
        assertThatThrownBy(() -> {
            LadderHeight.of(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}