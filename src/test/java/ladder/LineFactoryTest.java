package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineFactoryTest {
    @Test
    void create() {
        Line line = LineFactory.createLine(new RandomValueGenerator(), 4);
        System.out.println(line);
        assertThat(line.peopleSize()).isEqualTo(4);
    }
}
