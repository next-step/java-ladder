package ladder.domain;

import ladder.factories.LadderLineFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void create() {
        final List<LadderLine> ladderLines = Arrays.asList(
                LadderLineFactory.createAuto(5),
                LadderLineFactory.createAuto(5),
                LadderLineFactory.createAuto(5),
                LadderLineFactory.createAuto(5)
        );

        assertThat(new Ladder(ladderLines)).isEqualTo(new Ladder(ladderLines));
    }
}
