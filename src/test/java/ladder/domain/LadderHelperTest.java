package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHelperTest {
    @ParameterizedTest
    @CsvSource(value = {"3,5", "4,5"}, delimiter = ',')
    void create(int width, int height) {
        assertThat(new LadderHelper(width, height)).isEqualTo(new LadderHelper(width, height));
    }

    @ParameterizedTest
    @CsvSource(value = {"2,0", "2,-1", "1,1", "0,1"}, delimiter = ',')
    void invalid_create(int width, int height) {
        assertThatThrownBy(() -> new LadderHelper(width, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateSource")
    void generate(Predicate<Boolean> strategy, List<Line> result) {
        // given
        LadderHelper ladderHelper = new LadderHelper(3, 3);

        // when
        final List<Line> ladder = ladderHelper.generate(strategy);

        // then
        assertThat(ladder).isEqualTo(result);
    }

    static Stream<Arguments> generateSource() {
        return Stream.of(
                Arguments.of((Predicate<Boolean>) o -> false, Arrays.asList(
                        new Line(Arrays.asList(false, false, false)),
                        new Line(Arrays.asList(false, false, false)),
                        new Line(Arrays.asList(false, false, false))
                )),
                Arguments.of((Predicate<Boolean>) o -> !o, Arrays.asList(
                        new Line(Arrays.asList(false, true, false)),
                        new Line(Arrays.asList(false, true, false)),
                        new Line(Arrays.asList(false, true, false))
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_generateSource")
    void invalid_generate(Predicate<Boolean> strategy) {
        assertThatThrownBy(() -> new LadderHelper(3, 3).generate(strategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalid_generateSource() {
        return Stream.of(
                Arguments.of((Predicate<Boolean>) o -> true)
        );
    }
}
