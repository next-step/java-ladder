package ladder;

import ladder.domain.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantTest {
    @Test
    @DisplayName("이름이 같으면 같은 객체다")
    public void equalTest() {
        assertThat(Participant.name("test")).isEqualTo(Participant.name("test"));
    }

    @Test
    @DisplayName("이름은 5자 이내여야 한다.")
    public void nameLengthTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Participant.name("666666"));
        assertThatIllegalArgumentException().isThrownBy(() -> Participant.name(""));
    }
}
