package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderHeightTest {

    @ParameterizedTest(name = "사다리 높이 입력 테스트")
    @ValueSource(ints = {1, 5, 9, Integer.MAX_VALUE})
    public void createLadderHeight(int input) {
        assertThat(new LadderHeight(input).getHeight()).isEqualTo(input);
    }

    @DisplayName("1 미만의 사다리 높이 오류")
    @Test
    public void Exception_LadderHeight() {
        assertThatThrownBy(() -> new LadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1이상 이어야 합니다. 현재 사다리 입력 : " + 0);
    }
}
