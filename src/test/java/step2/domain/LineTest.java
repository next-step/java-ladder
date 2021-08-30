package step2.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    void Test() {
        Line line = new Line(2);
        System.out.println(line.getPoints());
    }
}