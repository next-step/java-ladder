package nextstep.ladder;

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


}