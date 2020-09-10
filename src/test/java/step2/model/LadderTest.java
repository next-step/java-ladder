package step2.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;

    private static Stream<Arguments> ladderTestForSpecificCase() {
        return Stream.of(
                Arguments.of(
                        new ArrayList<>().addAll(Arrays.asList(
                                Line.of(Arrays.asList(false, true)),
                                Line.of(Arrays.asList(true, false)),
                                Line.of(Arrays.asList(true, false)),
                                Line.of(Arrays.asList(true, false)),
                                Line.of(Arrays.asList(false, true))
                                )
                        )
                ),
                Arguments.of(
                        Person.of("Pobi", 0),
                        Person.of("John", 1),
                        Person.of("Jay", 2)
                )
        );
    }

    @Test
    void create_Ladder_Collection() {
        ladder = Ladder.of(Height.valueOf(4), 4, () -> true);
        assertThat(ladder.getLineOfHeight(0)).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("ladderTestForSpecificCase")
    void create_Ladder_Collection_For_Test(List<Line> ladderValue, List<Person> people) {
        ladder = Ladder.of(ladderValue);
        Participants participants = Participants.valueOf(people);
        ladder.move(participants);


    }
}
