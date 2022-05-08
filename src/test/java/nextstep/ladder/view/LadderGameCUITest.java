package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

class LadderGameCUITest {

    private LadderGameCUI cui = new LadderGameCUI();

    @Test
    void drawVisualizeTest() {
        Ladder ladder = Ladder.of(
            List.of("pobi", "start", "end", "12345", "1234"),
            6
        );

        cui.draw(ladder);
    }

}