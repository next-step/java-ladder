package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointCountTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {1, 5})
    public void create(final int pointCount) {
        assertThat(PointCount.of(pointCount)).isEqualTo(PointCount.of(pointCount));
    }

    @ParameterizedTest(name = "create failed : {arguments}")
    @ValueSource(ints = {-1, 0})
    public void createFailed(final int pointCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PointCount.of(pointCount));
    }

    @ParameterizedTest(name = "toInt: {arguments}")
    @ValueSource(ints = {2, 5})
    public void toInt(final int pointCount) {
        assertThat(PointCount.of(pointCount).toInt()).isEqualTo(pointCount);
    }

    @ParameterizedTest(name = "cache: {arguments}")
    @ValueSource(ints = {2, 5})
    public void cache(final int pointCount) {
        assertThat(PointCount.of(pointCount) == PointCount.of(pointCount)).isTrue();
    }

    public static PointCount ptc(int pointCount) {
        return PointCount.of(pointCount);
    }
}
