package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    void 참여자와_사다리높이로_Lines_객체를_생성한다() {
        final var lines = new Lines(4, 5);

        assertThat(lines.size()).isEqualTo(5);
    }

    @Test
    void 전체_Line의_사다리를_구한다() {
        final var lines = createMockLines();
        final var expected = "|-----|     |-----|\n|-----|     |-----|";

        final var actual = lines.drawLines();

        assertThat(actual).isEqualTo(expected);
    }

    private Lines createMockLines() {
        return new Lines(
                new Line(true, false, true),
                new Line(true, false, true)
        );
    }
}
