package nextstep.ladder.view;

import nextstep.ladder.domain.HorizontalLines;
import nextstep.ladder.view.dto.PrintLinesDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("출력")
class ResultViewTest {

    @DisplayName("사다리 출력")
    @Test
    public void printLadders() {
        // given
        final HorizontalLines horizontalLines = HorizontalLines.of(10, 6);

        // when
        ResultView.printLadders(new PrintLinesDto(horizontalLines.getValues()));

        // then

    }
}
