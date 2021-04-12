package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @Test
    @DisplayName("참가자 생성")
    void createParticipant() {
        Person participant = new Person("hwang");

        assertThat(participant).isEqualTo(new Person("hwang"));
    }

    @Test
    @DisplayName("참가자 이름이 5글자 초과 예외 테스트")
    void nameOverFiveLetterTest() {
        assertThatThrownBy(() -> new Person("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 이름이 1글자 예외 테스트")
    void nameUnderOneLetterTest() {
        assertThatThrownBy(() -> new Person(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
