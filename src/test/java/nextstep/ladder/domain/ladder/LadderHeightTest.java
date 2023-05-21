package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {

    @Test
    @DisplayName("사다리 높이 값을 반환한다.")
    void test01() {
        int expected = 5;
        LadderHeight ladderHeight = LadderHeight.from(expected);

        assertThat(ladderHeight.getHeight()).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 높이 값은 1 이상 이어야 한다.")
    void test02() {
        assertThatThrownBy(() -> LadderHeight.from(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
