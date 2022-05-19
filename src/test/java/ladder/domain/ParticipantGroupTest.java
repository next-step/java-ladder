package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantGroupTest {
    @ParameterizedTest
    @NullSource
    @DisplayName("참가자 리스트가 null 인 경우 예외가 발생한다.")
    void ParticipantGroup_참가자들_null(List<Participant> participants) {
        assertThatThrownBy(() -> new ParticipantGroup(participants)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 수를 카운팅 한다.")
    void participantsCount_참가자_카운팅() {
        List<Participant> participants = List.of(new Participant("wu2ee"), new Participant("pobi"), new Participant("honux"));
        assertThat(new ParticipantGroup(participants).participantsCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("참가자가 2명 미만일 경우 예외가 발생한다.")
    void ParticipantsGroup_참가자_2명_미만() {
        List<Participant> participants = List.of(new Participant("wu2ee"));
        assertThatThrownBy(() -> new ParticipantGroup(participants)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 이름 중 최대 길이를 반환한다.")
    void maxParticipantNameLength_참가자_이름_최대_길이() {
        List<Participant> participants = List.of(new Participant("k"), new Participant("kbstv"), new Participant("kb"));
        assertThat(new ParticipantGroup(participants).maxParticipantNameLength()).isEqualTo(5);
    }

    @Test
    @DisplayName("참가자 이름이 중복될 경우 예외가 발생한다.")
    void ParticipantGroup_참가자_이름_중복() {
        List<Participant> participants = List.of(new Participant("wu2ee"), new Participant("pobi"), new Participant("wu2ee"));
        assertThatThrownBy(() -> new ParticipantGroup(participants)).isInstanceOf(IllegalArgumentException.class);
    }
}