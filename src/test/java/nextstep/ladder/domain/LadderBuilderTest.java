package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.PlayersTest.ps;
import static nextstep.ladder.domain.ResultsTest.rs;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderBuilderTest {
    @Test
    public void create() {
        final Players players = ps("name1", "name2");
        final Results results = rs("result1", "result2");
        assertThat(LadderBuilder.of(players, results)).isEqualTo(LadderBuilder.of(players, results));
    }

    @Test
    public void createFailed() {
        final Players players = ps("name1", "name2");
        final Results results = rs("result1", "result2");
        assertThat(LadderBuilder.of(players, results)).isEqualTo(LadderBuilder.of(players, results));
    }

    @Test
    public void build() {
        final Players players = ps("name1", "name2");
        final Results results = rs("result1", "result2");
        final LadderBuilder builder = LadderBuilder.of(players, results);
        final int height = 5;
        assertThat(Ladder.of(players.count(), height, TestLineStrategy.NO_LINE_STRATEGY))
                .isEqualTo(builder.build(height, TestLineStrategy.NO_LINE_STRATEGY));
    }
}
