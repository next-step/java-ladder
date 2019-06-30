package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {
    @Test
    @DisplayName("주어진 이름으로 생성된다")
    void constructor() {
        String name = "pobi";
        Participant participant = new Participant(name);
        assertThat(participant.getName()).isEqualTo(name);
    }
}
