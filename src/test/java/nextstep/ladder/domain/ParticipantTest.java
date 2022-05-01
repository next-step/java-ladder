package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ParticipantTest {

    @ParameterizedTest(name = "참여자의 이름은 비어있거나 5글자보다 길면 안 된다.")
    @ValueSource(strings = {"longer than 5 characters", " ", ""})
    void validation(String invalidName) {
        assertThatThrownBy(() -> new Participant(invalidName))
                .isInstanceOf(InvalidParticipantNameException.class);
    }

    @Test
    void equals() {
        assertThat(new Participant("abc"))
                .isEqualTo(new Participant("abc"));
    }
}
