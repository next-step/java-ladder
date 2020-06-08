package ladder.step4.domain;

import ladder.step4.exception.ParticipantsMinimumSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantsTest {

    @DisplayName("참여자가 2명 미만일 경우에 ParticipantsMinimumSizeException 발생")
    @Test
    void 참여자수_검증_테스트() {
        assertThatExceptionOfType(ParticipantsMinimumSizeException.class)
            .isThrownBy(() -> Participants.of("a"));
    }

    @DisplayName("Participatns에 Participant가 존재하는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("provideParticipantsOfParticipant")
    void 참여자_확인_테스트(Participants participants, Participant participant) {
        assertEquals(
            participant,
            participants.stream()
                        .filter(v -> v == participant)
                        .findAny()
                        .orElse(null));
    }

    private static Stream<Arguments> provideParticipantsOfParticipant() {
        Participants participants = Participants.of("aa,bb,cc");
        return Stream.of(
            Arguments.of(participants, Participant.valueOf("aa")),
            Arguments.of(participants, Participant.valueOf("bb")),
            Arguments.of(participants, Participant.valueOf("cc"))
        );
    }
}
