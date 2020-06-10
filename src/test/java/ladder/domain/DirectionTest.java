package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    private final int nowLocation = 1;

    @ParameterizedTest
    @CsvSource(value = {"true,0", "false,1"})
    @DisplayName("왼쪽에 다리 있을 경우 이동")
    void goLeft(boolean left, int nextLocation) {
        int result = Direction.goLeft(left, nowLocation);
        assertThat(result).isEqualTo(nextLocation);
    }

    @ParameterizedTest
    @CsvSource(value = {"true,2", "false,1"})
    @DisplayName("오른쪽에 다리 있을 경우 이동")
    void goRight(boolean right, int nextLocation) {
        int result = Direction.goRight(right, nowLocation);
        assertThat(result).isEqualTo(nextLocation);
    }
}
