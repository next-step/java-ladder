package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderStrategy;
import ladder.domain.Line;
import ladder.domain.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @Test
    void 사다리_생성() {
        LadderStrategy ladder = Ladder.generateLadder(5, 4);
        assertThat(ladder).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 올바르지_않은_사다리_높이(int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.generateLadder(height, 4));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,3", "1,1", "2,0", "3,2"})
    void 도착지점_찾기(int departure, int arrival) {
        LadderStrategy ladder = new Ladder(List.of(new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))));

        assertThat(ladder.arrival(Position.departurePosition(departure)))
                .isEqualTo(new Position(3, arrival));
    }
}
