package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLinesTest {
    int lineLength = 3;
    Names names = Names.of("1,2,3");
    VerticalLines verticalLines;
    HorizontalLines horizontalLines;

    @BeforeEach
    void setUp() {
        Participants participants = Participants.of(names);
        verticalLines = new VerticalLines(participants.size(), lineLength);
        horizontalLines = HorizontalLines.of(verticalLines);
    }

    @Test
    @DisplayName("HorizontalLines 는 VerticalLines 을 인자로 받아 of 로 생성한다")
    void of() {
        assertThat(horizontalLines.size()).isEqualTo(names.getNames().size());
    }
}
