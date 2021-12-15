package nextstep.ladder.model;

import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LinesTest {

    @Test
    @DisplayName("Lines 출력 테스트")
    void viewCheck() {
        Lines lines = new Lines(10, 20);
        OutputView.print(lines);
    }
}