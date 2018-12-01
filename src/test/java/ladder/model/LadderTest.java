package ladder.model;

import org.junit.Test;

import static ladder.model.ParticipantsTest.DEFAULT_PARTICIPANTS;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 생성() {
        assertThat(Ladder.from(5, DEFAULT_PARTICIPANTS).getLines().size()).isEqualTo(5);
    }
}
