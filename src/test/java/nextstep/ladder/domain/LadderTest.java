package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;
    private List<Point> list = Arrays.asList(new Point(Direction.LEFT), new Point(Direction.RIGHT), new Point(Direction.LEFT));

    @BeforeEach
    void setUp() {
        ladder = new Ladder(list);
    }

    @Test
    void height() {
        assertThat(ladder.height()).isEqualTo(list.size());
    }

    @Test
    void addHeight() {
        Ladder ladder = new Ladder();
        ladder.addHeight(Direction.LEFT);
        assertThat(ladder.height()).isEqualTo(1);
    }

    @Test
    void direction() {
        assertThat(ladder.direction(1)).isEqualTo(Direction.RIGHT);
    }
}
