package nextstep.ladder.view;

import java.util.List;
import java.util.Random;
import nextstep.ladder.domain.ConnectPolicy;
import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

class LadderGameOutputCuiTest {

    private LadderGameOutputCui outputCui = new LadderGameOutputCui();

    private ConnectPolicy connectPolicy = () -> new Random().nextBoolean();

    @Test
    void drawVisualizeTest() {
        Ladder ladder = Ladder.of(
            List.of("pobi", "start", "end", "1234", "12345", "12", "1"),
            List.of("꽝", "꽝", "꽝", "꽝", "꽝", "꽝", "꽝"),
            11,
            connectPolicy
        );

        System.out.println(ladder.getLines());

        outputCui.draw(ladder);
    }

    @Test
    void drawVisualizeTest2() {
        Ladder ladder = Ladder.of(
            List.of("pobi", "start", "end"),
            List.of("꽝","꽝","1000"),
            2,
            connectPolicy
        );

        System.out.println(ladder.getLines());

        outputCui.draw(ladder);
    }

}