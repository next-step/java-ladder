package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.HeightTest.h;
import static nextstep.ladder.domain.LadderFrameTest.lf;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NewLadderBuilderTest {
    @Test
    public void create() {
        final LadderFrame ladderFrame = lf(List.of("name1", "name2"), List.of("result1", "result2"));
        final int height = 5;
        assertThat(NewLadderBuilder.of(ladderFrame, height)).isEqualTo(NewLadderBuilder.of(ladderFrame, height));
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
                .isThrownBy(() -> NewLadderBuilder.of(ladderFrame, height))
                .withMessageContaining("cannot be null");
    }

    @Test
    public void build() {
        final List<String> players = List.of("name1", "name2");
        final List<String> results = List.of("result1", "result2");
        final int height = 5;
        final NewLadderBuilder builder = NewLadderBuilder.of(lf(players, results), height);
        assertThat(NewLadder.of(players.size(), height, NO_LINE_STRATEGY))
                .isEqualTo(builder.build(NO_LINE_STRATEGY));
    }
}
