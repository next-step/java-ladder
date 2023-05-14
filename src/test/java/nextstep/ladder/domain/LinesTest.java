package nextstep.ladder.domain;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    private Lines lines = new Lines();

    @BeforeEach
    void setUp() {
        lines.addLine(new Line(new Position(0, 0), new Position(1, 0)));
    }

    @ParameterizedTest(name = "Line클래스 next 메소드 호출 시 이동된 포지션 결과 검증.")
    @CsvSource(value = {
            "0|0|1|1",
            "1|0|0|1",
            "2|0|2|1"
    }, delimiter = '|')
    public void 포지션_이동_위치_검증(int x, int y, int move_x, int move_y) {
        assertThat(lines.next(new Position(x, y))).isEqualTo(new Position(move_x, move_y));
    }


}