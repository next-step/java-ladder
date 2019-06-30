package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {
    @Test
    @DisplayName("주어진 이름으로 생성된다")
    void constructor() {
        Name name = new Name("pobi");
        Participant participant = new Participant(name);
        assertThat(participant.getName()).isEqualTo(name);
    }
}
