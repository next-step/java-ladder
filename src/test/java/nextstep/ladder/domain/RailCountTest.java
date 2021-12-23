package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RailCountTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {2, 5})
    public void create(final int railCount) {
        assertThat(RailCount.of(railCount)).isEqualTo(RailCount.of(railCount));
    }

    @ParameterizedTest(name = "create failed : {arguments}")
    @ValueSource(ints = {-1, 0, 1})
    public void createFailed(final int railCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RailCount.of(railCount));
    }

    @ParameterizedTest(name = "toInt: {arguments}")
    @ValueSource(ints = {2, 5})
    public void toInt(final int railCount) {
        assertThat(RailCount.of(railCount).toInt()).isEqualTo(railCount);
    }

    @ParameterizedTest(name = "cache: {arguments}")
    @ValueSource(ints = {2, 5})
    public void cache(final int railCount) {
        assertThat(RailCount.of(railCount) == RailCount.of(railCount)).isTrue();
    }

    public static RailCount rc(int railCount) {
        return RailCount.of(railCount);
    }
}
