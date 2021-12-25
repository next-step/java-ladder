package nextstep.ladder.domain;

import java.util.List;

import nextstep.ladder.engine.LadderBuilder;
import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.engine.LadderRails;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Step4LadderFrameTest.lf;
import static nextstep.ladder.domain.Step4LadderRailsTest.lrs;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;

public class Step4LadderBuilderTest {
    @Test
    public void buildRails() {
        final LadderBuilder builder = new Step4LadderBuilder();
        final List<String> players = List.of("name1", "name2");
        final List<String> results = List.of("result1", "result2");
        assertThat(builder.buildRails(players, results)).isEqualTo(builder.buildRails(players, results));
    }

    @Test
    public void buildFrame() {
        final LadderBuilder builder = new Step4LadderBuilder();
        final List<String> players = List.of("name1", "name2");
        final List<String> results = List.of("result1", "result2");
        final int height = 5;
        final LadderRails rails = lrs(players, results);
        assertThat(builder.buildFrame(rails, height)).isEqualTo(builder.buildFrame(rails, height));
    }

    @Test
    public void buildLadder() {
        final LadderBuilder builder = new Step4LadderBuilder();
        final List<String> players = List.of("name1", "name2");
        final List<String> results = List.of("result1", "result2");
        final int height = 5;
        final LadderFrame frame = lf(players, results, height);
        assertThat(builder.buildLadder(frame, NO_LINE_STRATEGY))
                .isEqualTo(builder.buildLadder(frame, NO_LINE_STRATEGY));
    }
}
