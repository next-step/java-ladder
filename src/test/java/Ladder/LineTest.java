package Ladder;

import Ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    void ErrorOnLineValidation() {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        points.add(true);
        points.add(true);

        assertThatThrownBy(() -> {
            Line.of(points);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
