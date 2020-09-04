package step2.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void create_Line_With_AllLine() {
        Line line = new Line();
        line.drawNewLine(5, ()->true);
        assertThat(line.printRungs()).contains("true");
    }

    @Test
    void create_Line_With_Draw_Strategy() {
        Line line = new Line();
        line.drawNewLine(5,()->true);
        System.out.println(line.printRungs());
    }
}
