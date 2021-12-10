package nextstep.ladder.domain;

import nextstep.ladder.domain.line.LineGenerateStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {1, 10})
    public void create(int numberOfPlayer) {
        assertThat(Line.of(numberOfPlayer, LineGenerateStrategy.NO_LINE_STRATEGY))
                .isEqualTo(Line.of(numberOfPlayer, LineGenerateStrategy.NO_LINE_STRATEGY));
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullSource
    public void createFailed(LineGenerateStrategy strategy) {
        final int numberOfPlayer = 5;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(numberOfPlayer, strategy))
                .withMessageContaining("cannot be null");
    }
}
