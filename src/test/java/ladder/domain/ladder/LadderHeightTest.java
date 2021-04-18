package ladder.domain.ladder;

import ladder.exception.InputNegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {

    @DisplayName("LadderHeight 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        int height = 5;

        // when
        LadderHeight ladderHeight = LadderHeight.valueOf(height);

        // then
        assertThat(ladderHeight).isNotNull();
    }

    @DisplayName("LadderHeight 인스턴스 음수 입력시 예외처리 테스트")
    @Test
    void 검증_음수() {
        // given
        int height = -1;

        // when
        assertThatThrownBy(()->LadderHeight.valueOf(height))
                .isInstanceOf(InputNegativeNumberException.class)
                .hasMessage("음수의 값이 입력되었습니다.");

    }


    @DisplayName("LadderHeight 인스턴스 소유한 값 반환 테스트")
    @Test
    void 반환_소유값() {
        // given
        int expected = 5;

        // when
        LadderHeight ladderHeight = LadderHeight.valueOf(expected);
        int actual = ladderHeight.height();

        assertThat(actual).isEqualTo(expected);
    }
}