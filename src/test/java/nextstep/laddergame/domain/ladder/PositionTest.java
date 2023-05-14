package nextstep.laddergame.domain.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @ParameterizedTest(name = "이동 결과 확인")
    @CsvSource(value = {"true,false,-1", "false,true,1", "false,false,0"})
    void moveResult(boolean left, boolean right, int result) {
        final Position position = new Position(0, Direction.first(left).next(right));

        assertThat(position.moveResult())
                .isEqualTo(result);
    }
}
