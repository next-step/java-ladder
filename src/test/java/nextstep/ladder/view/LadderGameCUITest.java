package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

class LadderGameCUITest {

    private LadderGameCUI cui = new LadderGameCUI();

    @Test
    void drawVisualizeTest() {
        Ladder ladder = Ladder.of(
            List.of("pobi", "start", "end", "1234", "12345", "12"),
            10
        );

        cui.draw(ladder);
    }

}