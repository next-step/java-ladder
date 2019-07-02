package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    void newLines() {

        Lines lines = Lines.of(4, 5);
        System.out.println(lines);

    }
}