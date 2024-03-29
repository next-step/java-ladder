package nextstep.ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    /**
     * |-----|     |
     */
    @Test
    void create() {
        Point first = Point.first(true);
        Point next = first.next(false);
        Point last = next.last();

        Line line = Line.from(first, next, last);
        assertThat(line).isEqualTo(Line.from(first, next, last));
    }

    @Test
    void 인원수가_2명_미만인경우_예외던진다() {
        assertThatThrownBy(() -> Line.from(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * |-----|     |-----|
     */
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    void move(int position, int expected) {
        Player player = new Player("test", position);

        Line line = LineTestUtil.createLineBy(true, false, true);
        line.move(player);

        assertThat(player).isEqualTo(new Player("test", expected));
    }
}
