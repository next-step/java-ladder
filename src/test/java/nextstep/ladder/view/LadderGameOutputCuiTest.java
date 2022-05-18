package nextstep.ladder.view;

import java.util.List;
import java.util.Random;
import nextstep.ladder.domain.ConnectPolicy;
import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

class LadderGameOutputCuiTest {

    private LadderGameOutputCui outputCui = new LadderGameOutputCui();

    @Test
    void drawVisualizeTest() {
        Ladder ladder = Ladder.of(
            List.of("pobi", "start", "end", "1234", "12345", "12", "1"),
            List.of("꽝", "꽝", "꽝", "꽝", "꽝", "꽝", "꽝"),
            11
        );

        System.out.println(ladder.getLadderLines());

        outputCui.draw(ladder);
    }

    @Test
    void drawVisualizeTest2() {
        Ladder ladder = Ladder.of(
            List.of("pobi", "start", "end"),
            List.of("꽝","꽝","1000"),
            2
        );

        System.out.println(ladder.getLadderLines());

        outputCui.draw(ladder);
    }

}