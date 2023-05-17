package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 참여인원에_맞게_하나의_Line_객체를_생성한다() {
        final var actual1 = createMockLine();
        final var actual2 = new Line(true, true, true, true);

        assertThat(actual1).isEqualTo(actual2);
    }

    @Test
    void 하나의_Line_사다리를_구한다() {
        final var line = new Line(true, false, true);
        final var expected = "|-----|     |-----|";

        final var actual = line.drawLine();

        assertThat(actual).isEqualTo(expected);
    }

    private Line createMockLine() {
        return new Line(5, () -> true);
    }

}