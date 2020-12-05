package nextstep.ladder.auxiliary;

import nextstep.ladder.domain.DefaultLadderLine;
import nextstep.ladder.domain.alternative.NextStepLadderLine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLinesFactoryTest {
    @Test
    void createDefaultLadderLine() {
        assertThat(LadderLinesFactory.getConstructorFunction(DefaultLadderLine.class).apply(2, 1))
            .isInstanceOf(DefaultLadderLine.class);
    }

    @Test
    void createNextStepLadderLine() {
        assertThat(LadderLinesFactory.getConstructorFunction(NextStepLadderLine.class).apply(2, 1))
                .isInstanceOf(NextStepLadderLine.class);
    }
}
