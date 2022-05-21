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
    void minimum(List<Person> people, int maxHeight) {
        assertThatThrownBy(() -> Ladder.create(people, maxHeight)).isInstanceOf(MinimumException.class);
    }

    private static Stream<Arguments> isPeopleAndLineMinimum() {
        List<Person> person = List.of(Person.of("one"));
        List<Person> people = IntStream
                .range(0, 5)
                .mapToObj(i -> Person.of(String.valueOf(i)))
                .collect(Collectors.toList());

        return Stream.of(
                Arguments.of(person, 0),
                Arguments.of(person, -1),
                Arguments.of(people, 0),
                Arguments.of(people, -1),
                Arguments.of(null, 5),
                Arguments.of(new ArrayList<>(), 5)
        );
    }
}
