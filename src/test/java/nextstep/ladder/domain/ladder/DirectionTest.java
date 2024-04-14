package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @DisplayName("next는 현재 열 번호에서 이동할 경우 다음 열 번호를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"LEFT,2,1", "RIGHT,2,3", "NONE,2,2"})
    void next(Direction direction, int origin, int expected) {
        assertThat(direction.next(new ColumnIndex(origin)))
                .isEqualTo(new ColumnIndex(expected));
    }
}
