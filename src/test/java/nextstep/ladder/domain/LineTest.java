package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @ParameterizedTest(name = "Line의 다리는 연속으로 존재할 수 없고, 끝이 비어있어야한다.")
    @MethodSource("provideInvalidLine")
    void validation(List<Boolean> invalidLine) {

        assertThatThrownBy(() -> new Line(invalidLine))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List> provideInvalidLine() {
        return Stream.of(
                List.of(true, true, false),
                List.of(true, false, true));
    }

    @Test
    void apply() {
        Participants participants = Participants.createParticipants(List.of("a", "b", "c"));
        Line line = new Line(List.of(true, false, false));

        line.apply(participants);

        assertThat(participants.getParticipants())
                .containsExactly(new Participant("b"), new Participant("a"), new Participant("c"));
    }
}
