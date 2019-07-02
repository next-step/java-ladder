package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLinesTest {
    VerticalLines verticalLines;
    @Test
    @DisplayName("참여자 수 만큼 VerticalLine 이 생성된다.")
    void constructor() {
        Names names = Names.of("1,2");
        Participants participants = Participants.of(names);

        verticalLines = new VerticalLines(participants.size());
        assertThat(verticalLines.size()).isEqualTo(participants.size());
    }

    @Test
    @DisplayName("HorizontalLines 로 부터 VerticalLines 가 생성된다")
    void of() {
        HorizontalLines horizontalLines = HorizontalLines.of(Arrays.asList(false, true, false, true));
        verticalLines = VerticalLines.of(horizontalLines);
        assertThat(verticalLines.size()).isEqualTo(horizontalLines.size());
    }
}
