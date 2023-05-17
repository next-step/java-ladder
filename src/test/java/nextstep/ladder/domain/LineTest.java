package nextstep.ladder.domain;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private Position position;
    private Line line;

    @BeforeEach
    void setUp() {
        position = new Position(0, 0);
        line = new Line(new Position(0,0), new Position(1, 0));
    }

    @ParameterizedTest(name = "Line 클래스 생성 시 전달한 포지션 정보가 존재할경우 true 리턴" +
            "없을경우 false를 리턴해야한다.")
    @CsvSource(value = {
            "0|0|1|0|true",
            "1|1|2|1|false",
            "2|3|3|3|false",
            "3|4|4|4|false",
    }, delimiter = '|')
    void 라인_위치_검증(int x, int y, int next_x, int next_y, boolean result) {
        Line line = new Line(new Position(x, y), new Position(next_x, next_y));
        assertThat(line.hasPosition(position)).isEqualTo(result);
    }

    @ParameterizedTest(name = "사다리 생성시 라인이 겹치는것을 방지하기 위한 검증 테스트로 " +
            "매개변수로 생성한 라인 클래스가 TEST_LINE 라인클래스와 Position이 겹치는 경우 false를 리턴" +
            "겹치지 않는경우 true를 리턴해야 한다.")
    @CsvSource(value = {
            "0|0|1|0|true",
            "1|0|2|0|true",
            "0|0|2|0|true",
            "3|4|4|4|false",
    }, delimiter = '|')
    void 라인_위치_중복_검증(int x, int y, int next_x, int next_y, boolean result) {
        Line parameterLine = new Line(new Position(x, y), new Position(next_x, next_y));
        assertThat(line.isConflict(parameterLine)).isEqualTo(result);
    }

}