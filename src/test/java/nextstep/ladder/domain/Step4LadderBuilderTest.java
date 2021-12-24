package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.ConcreteLadderFrameTest.lf;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Step4LadderBuilderTest {
    @Test
    public void create() {
        final LadderFrame ladderFrame = lf(List.of("name1", "name2"), List.of("result1", "result2"));
        final int height = 5;
        assertThat(Step4LadderBuilder.of(ladderFrame, height)).isEqualTo(Step4LadderBuilder.of(ladderFrame, height));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(null, 5)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseCreateFailed")
    public void createFailed(LadderFrame ladderFrame, int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Step4LadderBuilder.of(ladderFrame, height))
                .withMessageContaining("cannot be null");
    }

    @Test
    public void build() {
        final List<String> players = List.of("name1", "name2");
        final List<String> results = List.of("result1", "result2");
        final int height = 5;
        final Step4LadderBuilder builder = Step4LadderBuilder.of(lf(players, results), height);
        assertThat(Step4Ladder.of(lf(players, results), height, NO_LINE_STRATEGY))
                .isEqualTo(builder.build(NO_LINE_STRATEGY));
    }
}
