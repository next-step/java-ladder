package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLinesTest {
    @Test
    @DisplayName("참여자 수 만큼 VerticalLine 이 생성된다.")
    void constructor() {
        Names names = Names.of("1,2");
        Participants participants = Participants.of(names);

        VerticalLines verticalLines = new VerticalLines(participants.size());
        assertThat(verticalLines.size()).isEqualTo(participants.size());
    }
}
