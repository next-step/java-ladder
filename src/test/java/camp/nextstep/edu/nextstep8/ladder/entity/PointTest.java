package camp.nextstep.edu.nextstep8.ladder.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @DisplayName("입력된 좌표와 맞는 좌표 인지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0:true",
            "1:1:false",
            "2:2:false",
            "3:3:false"
    }, delimiter = ':')
    public void matchTest(int x, int y, boolean expected) {
        // given
        Point point = new Point(0, 0);

        // when
        boolean result = point.match(x, y);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("시작점 마킹이 잘 되는지 확인")
    @Test
    public void markStartTest() {
        // given
        Point point = new Point(0, 0);

        // when
        point.markStart();

        // then
        assertThat(point.isStart()).isTrue();
    }

    @DisplayName("종료점 마킹이 잘 되는지 확인")
    @Test
    public void markEndTest() {
        // given
        Point point = new Point(0, 0);

        // when
        point.markEnd();

        // then
        assertThat(point.isEnd()).isTrue();
    }

    @DisplayName("한 Row의 마지막 좌표인지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0:false",
            "0:3:false",
            "0:4:true"
    }, delimiter = ':')
    public void meetLastTest(int x, int y, boolean expected) {
        // given
        int rowSize = 5;
        Point point = new Point(x, y);

        // when
        boolean result = point.meetLast(rowSize);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
