package nextstep.ladder.view;

import nextstep.ladder.domain.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("출력")
class ResultViewTest {

    @DisplayName("사다리 출력")
    @Test
    public void printLadders() {
        // given
        Lines lines = new Lines(10);
        for (int i = 0; i < 6; i++) {
            lines.add();
        }

        // when
        ResultView.printLadders(lines);

        // then

    }
}
