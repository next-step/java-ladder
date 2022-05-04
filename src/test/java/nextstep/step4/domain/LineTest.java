package nextstep.step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void createLine() {
        Line firstLine = Line.from(5);
        assertThat(firstLine.getPoints()).hasSize(5);
    }

    @Test
    void printLine() {
        Line firstLine = Line.from(5);
        System.out.println(firstLine);
    }
}