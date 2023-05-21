package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void of() {
        Line actual = Line.of(4, StubConnector.INSTANCE);
        Line expected = getLine();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("인덱스를 따라 오른쪽으로 이동가능한지 확인한다.")
    void canMoveOnRight() {
        Line line = getLine();

        assertThat(line.canMoveOnRight(0)).isFalse();
    }

    @Test
    @DisplayName("인덱스를 따라 왼쪽으로 이동가능한지 확인한다.")
    void canMoveOnLeft() {
        Line line = getLine();

        assertThat(line.canMoveOnLeft(0)).isFalse();
    }

    @Test
    @DisplayName("범위를 넘어가는 인덱스는 false로 반환한다.")
    void indexOutOfBoundException() {
        Line line = getLine();

        assertThat(line.canMoveOnLeft(-1)).isFalse();
        assertThat(line.canMoveOnRight(3)).isFalse();
    }

    public static Line getLine() {

        List<Boolean> expected = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            expected.add(false);

        }
        return new Line(expected, StubConnector.INSTANCE);
    }
    public static class StubConnector implements Connector {

        private static final Connector INSTANCE = new StubConnector();
        @Override
        public boolean connect() {
            return false;
        }

    }
}