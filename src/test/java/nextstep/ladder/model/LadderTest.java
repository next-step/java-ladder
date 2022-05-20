package nextstep.ladder.model;

import nextstep.ladder.exception.MinimumException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @ParameterizedTest(name = "최소 인원 예외 처리 - {index}")
    @MethodSource("isPeopleAndLineMinimum")
    void minimum(List<Person> people, List<Line> lines) {
        assertThatThrownBy(() -> Ladder.create(people, lines)).isInstanceOf(MinimumException.class);
    }

    private static Stream<Arguments> isPeopleAndLineMinimum() {
        List<Person> person = List.of(Person.is("one"));
        List<Person> people = IntStream
                .range(0, 5)
                .mapToObj(i -> Person.is(String.valueOf(i)))
                .collect(Collectors.toList());

        List<Line> line = List.of(Line.create(5));
        List<Line> lines = IntStream
                .range(0, 5)
                .mapToObj(i -> Line.create(5))
                .collect(Collectors.toList());

        return Stream.of(
                Arguments.of(person, null),
                Arguments.of(people, null),
                Arguments.of(person, new ArrayList<>()),
                Arguments.of(people, new ArrayList<>()),
                Arguments.of(null, line),
                Arguments.of(null, lines),
                Arguments.of(new ArrayList<>(), line),
                Arguments.of(new ArrayList<>(), lines)
        );
    }
}
