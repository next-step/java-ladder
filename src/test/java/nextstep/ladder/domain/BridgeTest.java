package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    @ParameterizedTest(name = "Bridge는 연속으로 존재할 수 없고, 끝이 비어있어야한다.")
    @MethodSource("provideInvalidBridge")
    void validation(List<Boolean> invalidBridge) {

        assertThatThrownBy(() -> new Bridge(invalidBridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List> provideInvalidBridge() {
        return Stream.of(
                List.of(true, true, false),
                List.of(true, false, true));
    }

    @Test
    void apply() {
        Participants participants = Participants.createParticipants(List.of("a", "b", "c"));
        Bridge bridge = new Bridge(List.of(true, false, false));

        bridge.apply(participants);

        assertThat(participants.getParticipants())
                .containsExactly(new Participant("b"), new Participant("a"), new Participant("c"));
    }
}
