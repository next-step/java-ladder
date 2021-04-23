package ladder.domain.ladder;

import ladder.exception.InputNegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @DisplayName("LadderHeight 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int height = 3;

        // when
        LadderHeight ladderHeight = LadderHeight.valueOf(height);

        // then
        assertThat(ladderHeight).isNotNull();
    }

    @DisplayName("LadderHeight 인스턴스에 음수 값 입력시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int height = -1;

        // when and then
        assertThatThrownBy(() -> LadderHeight.valueOf(height))
                .isInstanceOf(InputNegativeNumberException.class)
                .hasMessage("(%-1)이라는 음수의 값이 입력되었습니다.");
    }

}