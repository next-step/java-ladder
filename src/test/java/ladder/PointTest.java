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
    public void makePointObject(boolean isExisting) {
        assertThatCode(() -> {
            new Point(isExisting);
        }).doesNotThrowAnyException();
    }

    @DisplayName("Point 객체 값 확인 테스트")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void getIsOnCurrentPosition(boolean isExisting) {
        Point point = new Point(isExisting);

        assertThat(point.getIsExisting())
                .isEqualTo(isExisting);
    }

    @DisplayName("Point 객체 생성시 5이상의 난수는 true, 그 밑은 false 값을 가짐")
    @ParameterizedTest
    @CsvSource({"5, true", "4, false", "9, true", "0, false"})
    public void makePointObjectUsingRandomNumber(int randomNumber, boolean isExisting) {
        Point point = Point.drawPoint(randomNumber);

        assertThat(point.getIsExisting())
                .isEqualTo(isExisting);
    }
}
