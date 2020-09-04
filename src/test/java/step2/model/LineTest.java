package step2.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void create_Line_With_AllLine() {
        Line line = new Line(3);
        assertThat(line.printBranches()).contains("false");
    }
}
