package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.ladder.LadderHeightException;

public class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 0})
    @DisplayName("사다리의 높이는 1 이상의 자연수가 들어오지 않으면 Exception이 발생된다.")
    void ladderHeightExceptionTest(int input) {

        // when & then
        assertThatExceptionOfType(LadderHeightException.class)
            .isThrownBy(() -> LadderHeight.of(input))
            .withMessageMatching("사다리 높이는 0보다 큰 자연수만 들어와야 한다.");
    }

}
