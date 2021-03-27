package ladder.domain.ladderMap;

import ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5})
    @DisplayName("5의 약수가 4가 아닌 수의 초기값은 비어있다")
    void emptyValueCase(int inputInteger) {
        Point point = new Point(inputInteger);
        assertThat(point.empty()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9, 14, 19, 24})
    @DisplayName("5의 약수가 4인 수의 초기값은 |이다")
    void verticalValueCase(int inputInteger) {
        Point point = new Point(inputInteger);
        assertThat(point.vertical()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9, 14, 19, 24})
    @DisplayName("-로 바꿀 수 있다")
    void canChangeToHorizontalValue(int inputInteger) {
        Point point = new Point(inputInteger);
        point = point.nowHorizontal();
        assertThat(point.horizontal()).isTrue();
    }
}
