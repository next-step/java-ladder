package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @DisplayName("LadderHeight 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        int height = 5;

        // when
        LadderHeight ladderHeight = LadderHeight.valueOf(5);

        // then
        assertThat(ladderHeight).isNotNull();
    }

    @DisplayName("LadderHeight 인스턴스 음수 입력시 예외처리 테스트")
    @Test
    void 검증_음수() {
        // given
        int height = -1;

        // when
        assertThatThrownBy(()->LadderHeight.valueOf(5))
                .isInstanceOf(InputNegativeNumberException.class)
                .hasMessage("음수의 값이 입력되었습니다.");

    }
}