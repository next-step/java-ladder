package ladder.domain;

import ladder.exception.PlayersCountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.domain.Line.NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    void create() {
        Line actual = new Line(5, () -> true);
        Line expected = new Line(List.of(true, false, true, false));

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void create_참여자명_0_음수_오류(int playersCount) {
        assertThatThrownBy(() -> {
            Line actual = new Line(playersCount, () -> true);
        }).isInstanceOf(PlayersCountException.class)
                .hasMessage(NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE);

    }

    @Test
    void line() {
        Line line = new Line(4, () -> true);

        List<Boolean> actual = line.line();
        List<Boolean> expcected = List.of(true, false, true);

        assertThat(actual).isEqualTo(expcected);
        // 불변성
        assertThatThrownBy(() -> actual.add(false))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
