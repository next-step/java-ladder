package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import nextstep.ladder.domain.exception.InvalidCreateLineException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Line (가로줄)")
class HorizontalLineTest {

    public static Stream<List<Boolean>> validBridges() {
        return Stream.of(
            Arrays.asList(true, false, true, false, true),
            Arrays.asList(false, false, true, false, true),
            Arrays.asList(false, false, false, false, false),
            Arrays.asList(false, false, false, false, true)
        );
    }

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @MethodSource("validBridges")
    public void create(final List<Boolean> bridges) {
        // given

        // when
        final HorizontalLine horizontalLine = HorizontalLine.of(bridges);

        // then
        assertThat(horizontalLine).isNotNull();
    }

    public static Stream<List<Boolean>> notValidBridges() {
        return Stream.of(
            Arrays.asList(true, true, true, false, true),
            Arrays.asList(false, false, true, true, true),
            Arrays.asList(false, false, false, true, true)
        );
    }

    @DisplayName("[성공] 생성 - 유효하지 않은 초기 값")
    @ParameterizedTest
    @MethodSource("notValidBridges")
    public void create_notValidBridges(final List<Boolean> bridges) {
        // given

        // when
        assertThrows(InvalidCreateLineException.class, () -> HorizontalLine.of(bridges));

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
        final HorizontalLine horizontalLine = HorizontalLine.of(playerCount);

        // then
        assertThat(horizontalLine.size()).isEqualTo(playerCount + 1);
        assertThat(horizontalLine.getBridges().get(0)).isFalse();
        assertThat(horizontalLine.getBridges().stream()
            .distinct()
            .count()).isEqualTo(2);
    }

    public static Stream<Arguments> nextLine() {
        return Stream.of(
            Arguments.of(HorizontalLine.of(Arrays.asList(false, true, false, false, true, false)), 0, 1),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, true, false, false, true, false)), 1, 0),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, true, false, false, true, false)), 2, 2),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, true, false, false, true, false)), 3, 4),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, false, true, false, true, false)), 4, 3),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, false, true, false, true, false)), 0, 0),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, false, true, false, true, false)), 1, 2),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, false, true, false, true, false)), 2, 1),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, false, true, false, true, false)), 3, 4),
            Arguments.of(HorizontalLine.of(Arrays.asList(false, false, true, false, true, false)), 4, 3)
        );
    }

    @DisplayName("[성공] 다음 가로줄로 이동시 인덱스")
    @ParameterizedTest
    @MethodSource("nextLine")
    public void next(final HorizontalLine horizontalLine, final int current, final int expected) {
        // given

        // when
        final int next = horizontalLine.next(current);

        // then
        assertThat(next).isEqualTo(expected);
    }
}
