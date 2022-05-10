package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

class LadderGameOutputCuiTest {

    private LadderGameOutputCui outputCui = new LadderGameOutputCui();

    @Test
    void drawVisualizeTest() {
        Ladder ladder = Ladder.of(
            List.of("pobi", "start", "end", "1234", "12345", "12", "1"),
            11
        );

        System.out.println(ladder.getLines());

        outputCui.draw(ladder);
    }

    @Test
    void drawVisualizeTest2() {
        Ladder ladder = Ladder.of(
            List.of("pobi", "start", "end"),
            2
        );

        System.out.println(ladder.getLines());

        outputCui.draw(ladder);
    }

}