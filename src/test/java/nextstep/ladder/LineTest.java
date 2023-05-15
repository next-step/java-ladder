package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 이전에_다리가_있으면_중복되면_안된다() {
        int width = 5;

        Line line = new Line(width);

        assertThat(line.hasDuplicate()).isFalse();
    }
}