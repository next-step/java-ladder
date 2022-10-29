package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private final Ladder ladder = new Ladder(List.of(
            LadderLine.from(Direction.RIGHT, Direction.LEFT, Direction.NONE),
            LadderLine.from(Direction.NONE, Direction.NONE, Direction.NONE),
            LadderLine.from(Direction.NONE, Direction.RIGHT, Direction.LEFT)
    ));

    @DisplayName("첫 번째 라인의 인덱스를 전달하면 사다리의 마지막 라인의 인덱스를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,2",
            "1,0",
            "2,1",
    })
    void moveToLastLine(int index, int expected) {
        assertThat(ladder.moveToLastLine(index)).isEqualTo(expected);
    }


}
