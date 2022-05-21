package nextstep.ladder.model;

import nextstep.ladder.exception.MinimumException;
import nextstep.ladder.model.ladder.Ladder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @ParameterizedTest(name = "최소 인원 예외 처리 - {index}")
    @MethodSource("isPeopleAndLineMinimum")
    void minimum(int countOfPeople, int maxHeight, List<String> scores) {
        assertThatThrownBy(() -> Ladder.create(countOfPeople, maxHeight, scores)).isInstanceOf(MinimumException.class);
    }

    private static Stream<Arguments> isPeopleAndLineMinimum() {
        List<String> singleName = List.of("a");
        List<String> doubleName = List.of("a", "b");

        return Stream.of(
                Arguments.of(1, 0, singleName),
                Arguments.of(1, -1, singleName),
                Arguments.of(1, -1, doubleName),
                Arguments.of(2, 0, doubleName),
                Arguments.of(2, -1, doubleName),
                Arguments.of(2, -1, singleName)
        );
    }
}
