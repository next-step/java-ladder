package nextstep.ladder.model.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @Test
    @DisplayName("참석자의 이름이 정상적으로 생성되는지 검증")
    void createTest() {
        Participant name = new Participant("lee", 0);

        assertThat(name).isEqualTo(new Participant("lee", 0));
    }

    @Test
    @DisplayName("사람 이름이 5자리를 넘어서는 안되는 예외 검증")
    void overExceptionTest() {

        assertThatThrownBy(() ->
                new Participant("jeonggi", 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사람 이름이 null 이거나 빈값이면 안되는 예외 검증")
    @NullAndEmptySource
    void emptyExceptionTest(String input) {

        assertThatThrownBy(() ->
                new Participant(input, 0)).isInstanceOf(NullPointerException.class);

    }
}
