package nextstep.ladder.domain;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static final Position TEST_POSITION = new Position(0, 0);
    private static final Line TEST_LINE = new Line(
      new Position(0,0), new Position(1, 0)
    );

    @ParameterizedTest(name = "Line클래스에 testPosion이 존재할경우 true를 리턴해야한다.")
    @CsvSource(value = {
            "0|0|1|0|true",
            "1|1|2|1|false",
            "2|3|3|3|false",
            "3|4|4|4|false",
    }, delimiter = '|')
    void 라인_위치_검증(int x, int y, int next_x, int next_y, boolean result) {
        Line line = new Line(new Position(x, y), new Position(next_x, next_y));
        assertThat(line.hasPosition(TEST_POSITION)).isEqualTo(result);
    }

    @ParameterizedTest(name = "Line클래스에 move 메소드 호출 시 이동할 Position에 위치를 리턴해야한다.")
    @CsvSource(value = {
            "0|0|1|0",
            "1|1|2|1",
            "2|3|3|3",
            "3|4|4|4",
    }, delimiter = '|')
    void 라인_이동_위치_검증(int x, int y, int next_x, int next_y) {
        Line line = new Line(new Position(x, y), new Position(next_x, next_y));
        assertThat(line.move(new Position(x,y))).isEqualTo(new Position(next_x, next_y));
    }

    @ParameterizedTest(name = "Line클래스에 isConflict 메소드 호출 시 result 결과가 나와야한다.")
    @CsvSource(value = {
            "0|0|1|0|true",
            "1|0|2|0|true",
            "0|0|2|0|true",
            "3|4|4|4|false",
    }, delimiter = '|')
    void 라인_위치_중복_검증(int x, int y, int next_x, int next_y, boolean result) {
        Line line = new Line(new Position(x, y), new Position(next_x, next_y));
        assertThat(TEST_LINE.isConflict(line)).isEqualTo(result);
    }

}