package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DotTest {
    @Test
    void create() {
        Dot dot2 = new Dot(0, false);
        assertFalse(dot2.getValue());
    }

    @Test
    @DisplayName("line의 첫 값이 True")
    void setValue_normal() {
        Line line = new Line(3, true);
        assertTrue(line.getDots().equals(List.of(true, false, false)));
    }

    @Test
    @DisplayName("line의 첫 값이 false")
    void setValue_normal2() {
        Line line = new Line(3, false);
        assertTrue(line.getDots().equals(List.of(false, true, false)));
    }
}
