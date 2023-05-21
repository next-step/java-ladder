package ladder;

import static ladder.domain.exception.LadderException.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import ladder.domain.Participant;
import ladder.domain.exception.LadderException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class participantTest {

    @Test
    @DisplayName("참가자 생성 테스트")
    void generateParticipantTest() {
        String name = "next";
        Participant participant = Participant.from(name);
        Assertions.assertThat(participant.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("참가자 생성 예외 테스트")
    @MethodSource("participantValidationArgument")
    void generateParticipantExceptionTest(String name, Class<Exception> clazz, LadderException exception) {
        Assertions.assertThatThrownBy(() -> Participant.from(name))
                .isInstanceOf(clazz)
                .hasMessage(exception.getMessage());
    }

    static Stream<Arguments> participantValidationArgument() {
        return Stream.of(
                Arguments.of("laminett", IllegalArgumentException.class, PARTICIPANT_NAME_OVER_LIMIT),
                Arguments.of(null, IllegalArgumentException.class, PARTICIPANT_NAME_IS_NULL),
                Arguments.of("", IllegalArgumentException.class, PARTICIPANT_NAME_IS_NULL)
        );
    }

    @Test
    void ttt() {
        List<String> names = new ArrayList<>(Arrays.asList("John", "Jane", "Jack", "Dennis"));

        List<Integer> ages = new ArrayList<>(Arrays.asList(24, 25, 27));

        IntStream
                .range(0, Math.min(names.size(), ages.size()))
                .mapToObj(i -> names.get(i) + ":" + ages.get(i));

    }

}
