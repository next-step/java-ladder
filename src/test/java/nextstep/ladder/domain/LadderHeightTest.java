package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10})
    @DisplayName("사다리 높이를 입력하면, 사다리 높이를 저장한 LadderHeight 객체가 생성된다.")
    void testLadderHeightConstructor() {
        //given
        //when
        LadderHeight ladderHeight = new LadderHeight(20);

        //then
        assertThat(ladderHeight).isNotNull();
        assertThat(ladderHeight.height()).isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -3})
    @DisplayName("1미만의 사다리 높이를 입력하면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionIfLadderHeightIsInvalid(int height) {
        //given, when, then
        assertThatThrownBy(() -> new LadderHeight(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 사다리 높이는 1 이상이어야 합니다.");
    }
}
