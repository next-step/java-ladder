package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @Test
    void 사람이름은_최대_5글자() {
        Participant participant = new Participant("사람이름");

        assertThat(participant.getName()).isEqualTo("사람이름");
    }

    @Test
    void 사람이름이_5글자가_넘으면_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            Participant participant = new Participant("사람이름5글자초과");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
