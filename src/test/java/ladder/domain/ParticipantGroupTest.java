package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantGroupTest {
    @ParameterizedTest
    @NullSource
    void ParticipantGroup_참가자들이_null_인_경우(List<Participant> participants) {
        assertThatThrownBy(() -> new ParticipantGroup(participants)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void participantsCount_참가자_카운팅() {
        List<Participant> participants = List.of(new Participant(new Name("wu2ee")), new Participant(new Name("pobi")), new Participant(new Name("honux")));
        assertThat(new ParticipantGroup(participants).participantsCount()).isEqualTo(3);
    }

    @Test
    void ParticipantsGroup_참가자가_2명_미만인_경우() {
        List<Participant> participants = List.of(new Participant(new Name("wu2ee")));
        assertThatThrownBy(() -> new ParticipantGroup(participants)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void maxParticipantNameLength_참가자_이름중_최대_길이() {
        List<Participant> participants = List.of(new Participant(new Name("k")), new Participant(new Name("kbstv")), new Participant(new Name("kb")));
        assertThat(new ParticipantGroup(participants).maxParticipantNameLength()).isEqualTo(5);
    }
}