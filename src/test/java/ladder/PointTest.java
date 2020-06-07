package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PointTest {

    @DisplayName("Point 객체 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void makePointObject(boolean isOnCurrentPosition) {
        assertThatCode(() -> {
            new Point(isOnCurrentPosition);
        }).doesNotThrowAnyException();
    }

    @DisplayName("Point 객체 값 확인 테스트")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void getIsOnCurrentPosition(boolean isOnCurrentPosition) {
        Point point = new Point(isOnCurrentPosition);

        assertThat(point.getIsOnCurrentPosition())
                .isEqualTo(isOnCurrentPosition);
    }

    @DisplayName("Point 객체 생성시 5이상의 난수는 true, 그 밑은 false 값을 가짐")
    @ParameterizedTest
    @CsvSource({"5, true", "4, false", "9, true", "0, false"})
    public void makePointObjectUsingRandomNumber(int randomNumber, boolean isOnCurrentPosition) {
        Point point = Point.of(randomNumber);

        assertThat(point.getIsOnCurrentPosition())
                .isEqualTo(isOnCurrentPosition);
    }
}
