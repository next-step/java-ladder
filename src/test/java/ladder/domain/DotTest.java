package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DotTest {
    @Test
    void create() {
        Dot dot1 = Dot.ofInitDot(0);
        Dot dot2 = new Dot(0, false);
        assertTrue(dot2.equals(dot1));
    }

    @Test
    @DisplayName("line의 첫 값이 True")
    void setValue_normal() {
        Line line = new Line(3);
        line.buildLine(true);
        assertTrue(line.getDots().equals(List.of(true, false, false)));
    }

    @Test
    @DisplayName("line의 첫 값이 false")
    void setValue_normal2() {
        Line line = new Line(3);
        line.buildLine(false);
        assertTrue(line.getDots().equals(List.of(false, true, false)));
    }
}
