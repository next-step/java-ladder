package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineCountTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {1, 5})
    public void create(final int lineCount) {
        assertThat(LineCount.of(lineCount)).isEqualTo(LineCount.of(lineCount));
    }

    @ParameterizedTest(name = "create failed : {arguments}")
    @ValueSource(ints = {-1, 0})
    public void createFailed(final int lineCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LineCount.of(lineCount));
    }

    @ParameterizedTest(name = "toInt: {arguments}")
    @ValueSource(ints = {2, 5})
    public void toInt(final int lineCount) {
        assertThat(LineCount.of(lineCount).toInt()).isEqualTo(lineCount);
    }

    @ParameterizedTest(name = "cache: {arguments}")
    @ValueSource(ints = {2, 5})
    public void cache(final int lineCount) {
        assertThat(LineCount.of(lineCount) == LineCount.of(lineCount)).isTrue();
    }

    public static LineCount lc(int lineCount) {
        return LineCount.of(lineCount);
    }
}
