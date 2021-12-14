package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {
    @DisplayName("5글자 이하의 이름 텍스트로 참가자(Participant)객체를 생성한다. ")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "1234", "$$$!@", "####", "ABCDE"})
    void create(String name) {
        assertThat(new Participant(name).getName()).isEqualTo(name);
        assertThat(new Participant(new Name(name)).getName()).isEqualTo(name);
    }

    @DisplayName("참가자 이름이 5글자를 초과한 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi123", "123456", "######"})
    void exception(String name) {
        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
