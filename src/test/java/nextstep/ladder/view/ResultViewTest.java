package nextstep.ladder.view;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.view.dto.PrintLinesDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("출력")
class ResultViewTest {

    @DisplayName("사다리 출력")
    @Test
    public void printLadders() {
        // given
        final Lines lines = Lines.of(10, 6);

        // when
        ResultView.printLadders(new PrintLinesDto(lines.getValues()));

        // then

    }
}
