package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import nextstep.ladder.domain.exception.InvalidCreateLineException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Line (가로줄)")
class LineTest {

    public static Stream<List<Boolean>> validExists() {
        return Stream.of(
            Arrays.asList(true, false, true, false, true),
            Arrays.asList(false, false, true, false, true),
            Arrays.asList(false, false, false, false, false),
            Arrays.asList(false, false, false, false, true)
        );
    }

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @MethodSource("validExists")
    public void create(final List<Boolean> exists) {
        // given

        // when
        final Line line = Line.of(exists);

        // then
        assertThat(line).isNotNull();
    }

    public static Stream<List<Boolean>> notValidExists() {
        return Stream.of(
            Arrays.asList(true, true, true, false, true),
            Arrays.asList(false, false, true, true, true),
            Arrays.asList(false, false, false, true, true)
        );
    }

    @DisplayName("[성공] 생성 - 유효하지 않은 초기 값")
    @ParameterizedTest
    @MethodSource("notValidExists")
    public void create_notValidExists(final List<Boolean> exists) {
        // given

        // when
        assertThrows(InvalidCreateLineException.class, () -> Line.of(exists));

        // then
    }

    @DisplayName("[성공] 생성 - with참여자수")
    @ParameterizedTest
    @CsvSource(value = {
        "10"
    })
    public void create_withHeight(final int playerCount) {
        // given

        // when
        final Line line = Line.of(playerCount);

        // then
        assertThat(line.size()).isEqualTo(playerCount + 1);
        assertThat(line.getExists().get(0)).isFalse();
        assertThat(line.getExists().stream()
            .distinct()
            .count()).isEqualTo(2);
    }
}
