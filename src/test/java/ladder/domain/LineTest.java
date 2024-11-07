package ladder.domain;

import ladder.exception.LineException;
import ladder.exception.PlayersCountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.Line.NOT_ALLOWED_CREATE_ADJACENT_LINE_MESSAGE;
import static ladder.domain.Line.NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE;
import static org.assertj.core.api.Assertions.*;

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
    void create_라인이_겹치면_오류() {
        assertThatThrownBy(() -> new Line(List.of(true, true, false, false)))
                .isInstanceOf(LineException.class)
                .hasMessage(NOT_ALLOWED_CREATE_ADJACENT_LINE_MESSAGE);

        assertThatNoException()
                .isThrownBy(() -> new Line(List.of(true, false, false, false)));
    }

    @Test
    void getPoint() {
        List<Boolean> lineList = new ArrayList<>(List.of(false, true, false, true, false));
        Line line = new Line(lineList);
        List<Boolean> actual = line.getPoint();

        assertThat(actual).isEqualTo(lineList);
        assertThatThrownBy(() -> actual.add(false))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}