package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineHelperTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 10})
    void create(int width) {
        assertThat(new LineHelper(width)).isEqualTo(new LineHelper(width));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void invalid_create(int width) {
        assertThatThrownBy(() -> new LineHelper(width))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateSource")
    void generate(Predicate<Boolean> strategy, List<Boolean> result) {
        // given
        LineHelper lineHelper = new LineHelper(3);

        // when
        final List<Boolean> line = lineHelper.generate(strategy);

        // then
        assertThat(line).isEqualTo(result);
    }

    static Stream<Arguments> generateSource() {
        return Stream.of(
                Arguments.of((Predicate<Boolean>) o -> false, Arrays.asList(false, false, false)),
                Arguments.of((Predicate<Boolean>) o -> !o, Arrays.asList(false, true, false)),
                Arguments.of((Predicate<Boolean>) o -> true, Arrays.asList(false, true, true))
        );
    }
}
