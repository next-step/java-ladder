package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParticipantTest {

    @Test
    void 이름은_공백이거나_null_일_수_없다() {
        assertThatThrownBy(() -> new Participant(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 비어있을 수 없습니다.");

        assertThatThrownBy(() -> new Participant(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 비어있을 수 없습니다.");
    }
    @Test
    void 이름은_길이가_5보다_클_수_없다() {
        assertThatThrownBy(() -> new Participant("123456"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("이름은 최대");
    }

    @Test
    void 같은_이름() {
        Participant participant = new Participant("1");
        assertThat(participant.hasName("1")).isTrue();
        assertThat(participant.hasName("2")).isFalse();
    }

    @Test
    void 다른_이름() {
        Participant participant = new Participant("1");
        assertThat(participant.hasName("2")).isFalse();
    }
}