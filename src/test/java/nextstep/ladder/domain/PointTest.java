package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

    @ParameterizedTest
    @DisplayName("포인트 상태에 따라 수평선이 존재하는지 아닌지 찾는다.")
    @CsvSource(value = {"true, LINE", "false, NOTHING"})
    void valueOf(boolean pointStatus, Point expected) {
        // when
        Point result = Point.valueOf(pointStatus);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("두 포인트의 수평선이 서로 겹치는지 확인한다.")
    @CsvSource(value = {"LINE, LINE, true", "LINE, NOTHING, false", "NOTHING, LINE, false", "NOTHING, NOTHING, false"})
    void is_overlapping(Point point, Point otherPoint, boolean expected) {
        // when
        boolean result = point.isOverlapping(otherPoint);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("이전 포인트 상태에 따라 현재 포인트를 생성한다.")
    @CsvSource(value = {"LINE, false, NOTHING", "LINE, true, NOTHING","NOTHING, true, LINE", "NOTHING, false, NOTHING"})
    void create_non_overlapping_point(Point point, boolean tempStatus, Point expected) {
        // when
        Point result = point.createNonOverlappingPoint(tempStatus);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
