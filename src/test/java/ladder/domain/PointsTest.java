package ladder.domain;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PointsTest {
    private List<Point> points;

    @BeforeEach
    void setUp() {
        points = List.of(VERTICAL_LINE, HORIZON, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE);
    }

    @DisplayName("현재 라인의 시작 인덱스로 시작해서 다음 라인으로 갈 수 있는 포인트의 인덱스를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = { "0,3", "1,3", "2,3", "3,0", "5,7", "6,7", "7,5", "9,9" }, delimiter = ',')
    void getNextLineStartIndex(int startIndex, int nextLineStartIndex) {
        assertThat(new Points(points).getNextLineStartIndex(startIndex)).isEqualTo(nextLineStartIndex);
    }

    @DisplayName("현재 라인의 시작 인덱스가 유효하지 않거나 해당 인덱스의 포인트가 공백이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = { 4, 8, 100 })
    void getNextLineStartIndex_when_invalid_index(int startIndex) {
        assertThatThrownBy(() -> new Points(points).getNextLineStartIndex(startIndex))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid index. index="+startIndex);
    }
}
