package nextstep.ladder;

import nextstep.ladder.participant.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {

    @Test
    @DisplayName("참가자 생성하기.")
    void create() {
        Participant p1 = new Participant("john");
        assertThat(p1.getName()).isEqualTo("john");
    }

    @Test
    @DisplayName("참가자 이름은 최대 5글자 이다.")
    void checkNameValidation() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Participant("john123")
        ).withMessageContaining("최대 5글자");
    }

    @Test
    @DisplayName("위치 확인 테스트")
    void checkPositionTest(){
        Participant participant = new Participant("name");
        participant.setStartPosition(1,5);
        assertThat(participant.position().value()).isEqualTo(1);
    }

    @Test
    @DisplayName("위치 이동 테스트 (right 이동)")
    void moveRightPositionTest(){
        Participant participant = new Participant("name");
        participant.setStartPosition(1,5);

        participant.movePosition(1);
        assertThat(participant.position().value()).isEqualTo(2);
    }

    @Test
    @DisplayName("위치 이동 테스트 (left 이동)")
    void moveLeftPositionTest(){
        Participant participant = new Participant("name");
        participant.setStartPosition(1,5);

        participant.movePosition(0);
        assertThat(participant.position().value()).isEqualTo(0);
    }
}