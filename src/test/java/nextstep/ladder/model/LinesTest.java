package nextstep.ladder.model;

import nextstep.ladder.factory.LinesFactory;
import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    @DisplayName("Lines 출력 테스트")
    void viewCheck() {
        Lines lines = LinesFactory.of(10, 20);
        OutputView.print(lines);
    }
}