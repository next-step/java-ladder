package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class InputNameTypeTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "all   | ALL",
                    "yong  | EACH"
            },
            delimiter = '|'
    )
    public void from(String userInput, InputNameType type) {
        assertThat(InputNameType.from(userInput)).isEqualTo(type);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "yong | yong",
                    "all  | yong,ksy,pobi"
            },
            delimiter = '|'
    )
    public void name(String targetName, String expected) {
        // given
        List<String> names = List.of("yong", "ksy", "pobi");

        // when
        List<String> result = InputNameType.from(targetName).name(names, targetName);

        // then
        assertThat(result).containsAll(Arrays.stream(expected.split(",")).collect(Collectors.toList()));
    }
}
