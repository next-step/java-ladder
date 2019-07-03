package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @Test
    void 하나의Line을이루는points() {
        Line line = Line.countGamerOf(4);
        List<Boolean> points = line.getPoints();
        points.stream().forEach(System.out::println);
    }

    @Test
    void points의마지막요소값은무조건false() {
        Line line = Line.countGamerOf(5);
        Boolean point = line.getPoints().stream().reduce((first, second) -> second).get();
        assertThat(point).isFalse();
    }

    @Test
    void 게임참여자최소인원미달_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Line line = Line.countGamerOf(1);
        });
    }
}
