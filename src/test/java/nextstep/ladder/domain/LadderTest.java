package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    void create() {
        PointStrategy pointStrategy = () -> true;
        Ladder ladder = new Ladder(Arrays.asList(
                new Line(5, pointStrategy),
                new Line(5, pointStrategy),
                new Line(5, pointStrategy)
        ));
        assertThat(ladder.getLines().size()).isEqualTo(3);
    }
}
