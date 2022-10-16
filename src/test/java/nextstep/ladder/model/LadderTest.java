package nextstep.ladder.model;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {
    @ParameterizedTest(name = "사다리의 길이와 사람 수가 주어질 때, 사다리를 생성한다. 길이: {0}, 사람 수: {1}")
    @CsvSource({
        "3,3",
        "1,3"
    })
    void create(int ladderLength, int countOfPerson) {
        new Ladder(ladderLength, countOfPerson, () -> true);
    }

    @ParameterizedTest(name = "부적절한 사다리의 길이가 주어졌을 때, 예외가 던져진다. 길이: {0}")
    @ValueSource(ints = {-1, 0})
    void createWithInvalidLength(int ladderLength) {
        assertThatThrownBy(() -> new Ladder(ladderLength, 3, () -> true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("사다리의 높이는 양수여야 합니다");
    }

    @ParameterizedTest(name = "사다리 길이와 사람 수가 주어졌을 때, 각 위치에 대하여 사다리 타기를 수행합니다; 사다리 길이: {0}, 사람 수: {1}")
    @MethodSource("provideLadderMovingSource")
    void move(int ladderLength, int countOfPerson, List<Integer> expectedPositions) {
        Ladder ladder = new Ladder(ladderLength, countOfPerson, () -> true);

        List<Integer> positions = IntStream.range(0, countOfPerson)
            .map(ladder::move)
            .boxed()
            .collect(toList());

        assertThat(positions).isEqualTo(expectedPositions);
    }

    private static Stream<Arguments> provideLadderMovingSource() {
        return Stream.of(
            Arguments.of(3, 3, List.of(1, 0, 2)),
            Arguments.of(4, 4, List.of(0, 1, 2, 3)),
            Arguments.of(5, 5, List.of(1, 0, 3, 2, 4))
        );
    }
}
