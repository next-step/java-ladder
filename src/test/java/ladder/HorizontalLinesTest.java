package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HorizontalLinesTest {
    int lineLength = 3;
    Names names = Names.of("1,2,3");
    VerticalLines verticalLines;

    @BeforeEach
    void setUp() {
        Participants participants = Participants.of(names);
        verticalLines = new VerticalLines(participants.size(), lineLength);
    }

    @Test
    @DisplayName("HorizontalLines 는 VerticalLines 을 인자로 받아 of 로 생성한다")
    void of() {
        HorizontalLines horizontalLines = HorizontalLines.of(verticalLines);
        assertThat(horizontalLines.getLines().size()).isEqualTo(names.getNames().size())
    }
}
