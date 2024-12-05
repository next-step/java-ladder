package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
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
    /**
    a b c d
    |-| |-|
    |-| |-|
    |-| |-|
    **/
    @Test
    @DisplayName("참가자 move함수를 이용해 사다리를 타고 최종 위치로 간다")
    void move(){
        Lines lines = LinesTest.lines();
        Participant participant = new Participant("a");
        participant.move(lines);

        assertThat(participant.getPositionX()).isEqualTo(1);
        assertThat(participant.getPositionY()).isEqualTo(3);
    }
}
