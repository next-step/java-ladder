package seungjun.domain;

import ladder.LadderParticipant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderParticipantTest {
    @Test
    @DisplayName("[Name.equals] 같은 사람 이름이면 -> 동일 판정")
    public void same() {
        assertThat(new LadderParticipant("mymy"))
                .isEqualTo(new LadderParticipant("mymy"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("[Name.new] 사람 이름이 1~5자가 아니면 -> 예외 던짐")
    public void wrongNameLength(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new LadderParticipant(name);
                });
    }

    @Test
    @DisplayName("[Name.new] 이름에 null이 오면 -> 예외 던짐")
    public void nullName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new LadderParticipant(null);
                });
    }
}
