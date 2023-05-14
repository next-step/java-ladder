package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private static final Ladder LADDER = new Ladder(
            new TestLinesGenerator(), 5, 5
    );

    @ParameterizedTest(name = "Ladder클래스 move 메소드 호출 시 이동된 포지션 결과 검증.")
    @CsvSource(value = {
            "0|0|0|5",
            "1|0|1|5",
            "2|0|2|5",
            "3|0|4|5",
            "4|0|3|5"
    }, delimiter = '|')
    void 포지션_이동_위치_검증(int x, int y, int move_x, int move_y) {
        Position position = LADDER.move(new Position(x, y));
        assertThat(position).isEqualTo(new Position(move_x, move_y));
    }
}