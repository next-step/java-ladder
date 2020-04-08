package JavaLadder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    @Test
    public void lineConstructorTest() {
        Line line = new Line(5);
        assertThat(line.size()).isEqualTo(5);
    }
}
