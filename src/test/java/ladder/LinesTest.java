package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    @DisplayName("참여자 수와, 사다리 갯수만큼 사다리가 생성된다.")
    void constructor() {
        int lineLength = 5;
        Names names = Names.of("1,2");
        Participants participants = Participants.of(names);

        Lines lines = new Lines(participants.size(), lineLength);
        assertThat(lines.size()).isEqualTo(participants.size());
    }
}
