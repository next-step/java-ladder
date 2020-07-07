package ladder;

import ladder.domain.LadderCompensation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderCompensationTest {
    LadderCompensation ladderCompensation = new LadderCompensation("꽝,5000,꽝,500");

    @ParameterizedTest
    @DisplayName("유효하지 않은 인덱스의 보상을 부를 경우 실패")
    @ValueSource(ints = {4, 5, 6})
    void FailIfGetCompensationIndexInvalid(int input) {
        assertThatThrownBy(() -> ladderCompensation.getCompensation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 보상의 수가 실제 입력과 같은지 확인")
    void IsNumberOfCompensationSizeEqualWithInput() {
        int actual = ladderCompensation.getNumberOfCompensation();

        assertThat(actual).isEqualTo(4);
    }
}
