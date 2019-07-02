package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    void 하나의Line을이루는points() {
        Line line = new Line(4);
        List<Boolean> points = line.getPoints();
        points.stream().forEach(t -> System.out.println(t));
    }

    @Test
    void 게임참여자최소인원미달_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Line line = new Line(1);
        });
    }
}
