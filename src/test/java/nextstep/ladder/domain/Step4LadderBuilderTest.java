package nextstep.ladder.domain;

import java.util.List;

import nextstep.ladder.engine.LadderBuilder;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Step4LadderRailsTest.lf;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;

public class Step4LadderBuilderTest {
    @Test
    public void create() {
        final List<String> players = List.of("name1", "name2");
        final List<String> results = List.of("result1", "result2");
        assertThat(Step4LadderBuilder.of(players, results)).isEqualTo(Step4LadderBuilder.of(players, results));
    }

    @Test
    public void build() {
        final List<String> players = List.of("name1", "name2");
        final List<String> results = List.of("result1", "result2");
        final int height = 5;
        final LadderBuilder builder = Step4LadderBuilder.of(players, results);
        assertThat(Step4Ladder.of(lf(players, results), height, NO_LINE_STRATEGY))
                .isEqualTo(builder.build(5, NO_LINE_STRATEGY));
    }
}
