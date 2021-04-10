package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @Test
    @DisplayName("이름 미입력")
    void nameIsBlank() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participant(null))
                .withMessageMatching("참가자 이름을 입력해 주세요.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participant(" "))
                .withMessageMatching("참가자 이름을 입력해 주세요.");
    }
    
    @Test
    @DisplayName("5자 이상의 이름은 입력 불가")
    void name_maxLength() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participant("abcdef"))
                .withMessageMatching("참가자 이름은 최대 5글자까지 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("참가자 정상생성 테스트")
    void create() {
        // given when
        Participant participant = new Participant("pobi");

        // then
        assertThat("pobi").isEqualTo(participant.getName());
    }

}