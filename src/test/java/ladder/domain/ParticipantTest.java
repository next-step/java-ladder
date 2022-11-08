package ladder.domain;

import ladder.domain.user.Participant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @Test
    @DisplayName("5글짜 초과 이름 부여했을 때 예외 확인")
    void testExceptionWithNameLongerThan5(){
        Assertions.assertThatThrownBy(() -> new Participant("jackson"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("participant name length cannot be longer than 5");
    }

    @Test
    @DisplayName("공백 이름 부여했을 때 예외 확인")
    void testExceptionWithEmptyName(){
        Assertions.assertThatThrownBy(() -> new Participant(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("participant name cannot be empty");
    }
}
