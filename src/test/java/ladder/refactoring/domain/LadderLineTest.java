package ladder.refactoring.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    void creation_test() {
        int size = 5;
        LadderLine line = LadderLine.of(size);

        assertThat(line.getPoints().size()).isEqualTo(size);
    }
}
