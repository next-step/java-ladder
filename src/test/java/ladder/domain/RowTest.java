package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RowTest {
    @ParameterizedTest
    @CsvSource({
            "2, true",
            "3, true|false",
            "4, true|false|true",
            "5, true|false|true|false",
            "6, true|false|true|false|true"
    })
    void testAlways(int numberPerson, String expected) {
        List<Boolean> links = Arrays.stream(expected.split("\\|"))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());
        assertThat(
                Row.of(numberPerson, () -> true).getLinks().stream()
                        .map(Link::isLinked)
                        .collect(Collectors.toList())
        ).isEqualTo(links);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 4, 5, 6 })
    void testNever(int numberPerson) {
        List<Boolean> links = Stream.generate(() -> false)
                .limit(numberPerson - 1)
                .collect(Collectors.toList());
        assertThat(
                Row.of(numberPerson, () -> false).getLinks().stream()
                        .map(Link::isLinked)
                        .collect(Collectors.toList())
        ).isEqualTo(links);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void testEdge(int numberPerson) {
        assertThat(Row.of(numberPerson, () -> true).getLinks()).hasSize(0);
        assertThat(Row.of(numberPerson, () -> false).getLinks()).hasSize(0);
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 0 })
    void testInvalids(int numberPerson) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Row.of(numberPerson, () -> true));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Row.of(numberPerson, () -> false));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 1|0",
            "3, 1|0|2",
            "4, 1|0|3|2",
            "5, 1|0|3|2|4",
            "6, 1|0|3|2|5|4"
    })
    void testStepForAlways(int numberPerson, String expected) {
        List<Integer> when = IntStream.range(0, numberPerson)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> then = Arrays.stream(expected.split("\\|"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Row row = Row.of(numberPerson, () -> true);
        assertThat(row.step(when)).isEqualTo(then);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6 })
    void testStepForNever(int numberPerson) {
        List<Integer> when = IntStream.range(0, numberPerson)
                .boxed()
                .collect(Collectors.toList());
        Row row = Row.of(numberPerson, () -> false);
        assertThat(row.step(when)).isEqualTo(when);
    }
}
