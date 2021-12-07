package nextstep.ladder.model.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @Test
    @DisplayName("참석자의 이름이 정상적으로 생성되는지 검증")
    void createTest() {
        Participant name = new Participant("lee");

        assertThat(name).isEqualTo(new Participant("lee"));
    }

    @Test
    @DisplayName("사람이름이 5자리를 넘어서는 안되는 예외 검증")
    void exceptionTest() {

        assertThatThrownBy(() ->
                new Participant("jeonggi")).isInstanceOf(IllegalArgumentException.class);
    }
}
