package nextstep.ladder.domain;

import static nextstep.ladder.domain.Participants.ALL_PARTICIPANTS;
import static nextstep.ladder.domain.Participants.NO_TARGET_EQUATION_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    @DisplayName("타겟이 all이면 모든 참가자들을 생성한다.")
    void create_all_participants() {
        // given
        Participants participants = new Participants(List.of("tobi", "pobi", "jason"));

        // when
        Participants result = participants.createParticipants(ALL_PARTICIPANTS);

        // then
        assertThat(result).isEqualTo(new Participants(List.of("tobi", "pobi", "jason")));
    }

    @Test
    @DisplayName("특정 타겟이면 특정 타겟과 일치하는 참가자를 생성한다.")
    void create_target_participants() {
        // given
        Participants participants = new Participants(List.of("tobi", "pobi", "jason"));

        // when
        Participants result = participants.createParticipants("pobi");

        // then
        assertThat(result).isEqualTo(new Participants(new Participant("pobi", 1)));
    }

    @Test
    @DisplayName("특정 타겟과 일치하는 참가자가 없으면 예외를 던진다.")
    void no_target() {
        // given
        Participants participants = new Participants(List.of("tobi", "pobi", "jason"));

        // when // then
        assertThatThrownBy(() -> participants.createParticipants("sue"))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(NO_TARGET_EQUATION_EXCEPTION);
    }
}
