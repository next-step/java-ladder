package nextstep.step2.domain;

import nextstep.step2.generator.RandomBooleanGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @Test
    void 참여인원보다_한개_적은_Line_객체를_생성한다() {
        final var actual = createMockLine();

        assertThat(actual.points()).containsExactly(false, false, false);
    }

    @Test
    void 참여이원이_존재하지_않으면_예외를_던진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Line(0, new RandomBooleanGenerator())
        );
    }

    private Line createMockLine() {
        return new Line(4, () -> false);
    }
}
