package nextstep.ladder;

import nextstep.ladder.domain.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Participant.PARTICIPANT_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
@DisplayName("ParticipantTest 클래스는")
public class ParticipantTest {
    @Nested
    @DisplayName("checkParticipantLength 메소드는")
    class Describe_checkParticipantLength {
        @Nested
        @DisplayName(PARTICIPANT_SIZE + "가 넘는 길이의 참가자가 입력되면 ")
        class long_participant_length {
            @Test
            @DisplayName("이름의 길이가" + PARTICIPANT_SIZE + "를 초과합니다.를 반환")
            void long_participant_length() {
                assertThatThrownBy(() -> {
                    Participant.of("testtest");
                }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름의 길이가 " + PARTICIPANT_SIZE + "를 초과합니다.");
            }
        }

        @Nested
        @DisplayName("길이가 0인 참가자가 입력되면 ")
        class zero_participant_length {
            @Test
            @DisplayName("이름의 길이가 0보다 커야합니다.를 반환")
            void zero_participant_length() {
                assertThatThrownBy(() -> {
                    Participant.of("");
                }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름의 길이가 0보다 커야합니다.");
            }
        }
    }
}

