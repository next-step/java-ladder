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
    private Points points;

    @BeforeEach
    void setUp() {
        points = new Points(List.of(VERTICAL_LINE, HORIZON, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE));
    }

    @DisplayName("시작 인덱스로 시작해서 끝나는 인덱스를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = { "0,3", "1,3", "2,3", "3,0", "5,7", "6,7", "7,5", "9,9" }, delimiter = ',')
    void getEndIndex(int startIndex, int nextLineStartIndex) {
        assertThat(points.getEndIndex(startIndex)).isEqualTo(nextLineStartIndex);
    }

    @DisplayName("현재 라인의 시작 인덱스가 유효하지 않거나 해당 인덱스의 포인트가 공백이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = { 4, 8, 100 })
    void getEndIndex_when_invalid_index(int startIndex) {
        assertThatThrownBy(() -> points.getEndIndex(startIndex))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid index. index="+startIndex);
    }

    @DisplayName("다음 라인의 순서를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = { "0,0", "3,1", "5,2", "7,3", "9,4" }, delimiter = ',')
    void getNextLineOrderBy(int nextLineIndex, int nextLineOrder) {
        assertThat(points.getNextLineOrderBy(nextLineIndex)).isEqualTo(nextLineOrder);
    }

    @DisplayName("수직선 순서를 인덱스로 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = { "1,0", "2,3", "3,5", "4,7", "5,9" }, delimiter = ',')
    void getVerticalIndex(int order, int expected) {
        assertThat(points.getVerticalIndex(order)).isEqualTo(expected);
    }
}
