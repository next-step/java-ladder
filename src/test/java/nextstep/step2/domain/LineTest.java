package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 참여인원보다_한개_적은_Line_객체를_생성한다() {
        final var actual = createMockLine();

        assertThat(actual.points()).containsExactly(false, false, false);
    }

    private Line createMockLine() {
        return new Line(4, () -> false);
    }
}
