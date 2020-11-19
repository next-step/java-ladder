package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        assertThat(Line.init(sizeOfPerson));
    }

    @Test
    public void move() {
        Line line = Line.init(2);
        assertThat("ladder result : " + line.move(0))
                .isEqualTo("ladder result : 1");
    }
}
