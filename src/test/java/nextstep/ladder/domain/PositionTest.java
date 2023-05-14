package nextstep.ladder.domain;

import nextstep.ladder.domain.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @ParameterizedTest(name = "Position 클래스에 nextRowPosition 메소드 호출 시 y값이 1증가해야 한다.")
    @CsvSource(value = {
            "0|0|0|1",
            "1|1|1|2",
            "2|3|2|4",
            "3|4|3|5",
    }, delimiter = '|')
    void 포지션_이동_위치_검증(int x, int y, int next_x, int next_y) {
        assertThat(new Position(x, y).nextRowPosition()).isEqualTo(new Position(next_x, next_y));
    }


}