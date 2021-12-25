package nextstep.ladder.domain;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class IndexTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {0, 1, 11})
    public void create(final int index) {
        assertThat(Index.of(index)).isEqualTo(Index.of(index));
    }

    @ParameterizedTest(name = "create failed : {arguments}")
    @ValueSource(ints = {-1})
    public void createFailed(final int index) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Index.of(index));
    }

    @ParameterizedTest(name = "toInt: {arguments}")
    @ValueSource(ints = {0, 1})
    public void toInt(final int index) {
        assertThat(ix(index).toInt()).isEqualTo(index);
    }

    @ParameterizedTest(name = "next: {arguments}")
    @ValueSource(ints = {0, 1})
    public void next(final int index) {
        assertThat(ix(index).next()).isEqualTo(ix(index + 1));
    }

    static Stream<Arguments> parseJumpArguments() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(1, 0, 1),
                Arguments.of(1, -1, 0)
        );
    }

    @ParameterizedTest(name = "jump: {arguments}")
    @MethodSource("parseJumpArguments")
    public void jump(final int index, final int jump, final int expected) {
        assertThat(ix(index).jump(jump)).isEqualTo(ix(expected));
    }

    static Stream<Arguments> parseJumpFailedArguments() {
        return Stream.of(
                Arguments.of(0, -1),
                Arguments.of(1, -2)
        );
    }

    @ParameterizedTest(name = "jump failed: {arguments}")
    @MethodSource("parseJumpFailedArguments")
    public void jumpFailed(final int index, final int jump) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ix(index).jump(jump));
    }

    @ParameterizedTest(name = "cache: {arguments}")
    @ValueSource(ints = {0, 1})
    public void cache(final int index) {
        assertThat(ix(index) == ix(index)).isTrue();
    }

    public static Index ix(int index) {
        return Index.of(index);
    }
}
