package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLinesTest {
    @Test
    @DisplayName("참여자 수와, 사다리 높이만큼 사다리가 생성된다.")
    void constructor() {
        int lineHeight = 5;
        Names names = Names.of("1,2");
        Participants participants = Participants.of(names);

        VerticalLines verticalLines = new VerticalLines(participants.size(), lineHeight);
        assertThat(verticalLines.size()).isEqualTo(participants.size());
    }
}
