package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ParticipantTest {

    @Test
    void 유효한_참가자_이름으로_참가자를_만든다() {
        String name = "참가자이름";

        Participant participant = Participant.of(name);

        assertThat(participant).isNotNull();
        assertThat(participant.isSameNameWith(name)).isTrue();

    }

    @Test
    void 길이가_짧아_유효하지않은_참가자_이름으로_참가자를_만든다() {
        String name = "";

        assertThatThrownBy(() ->
            Participant.of(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_길어_유효하지않은_참가자_이름으로_참가자를_만든다() {
        String name = "참가자 이름이 너무길다";

        assertThatThrownBy(() ->
            Participant.of(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}