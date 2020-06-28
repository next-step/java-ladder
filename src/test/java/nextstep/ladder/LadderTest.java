package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.model.LadderStatus;
import nextstep.ladder.model.Line;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;
import nextstep.ladder.view.StandardOutputView;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
    @Test
    public void testSimpleLadder() {
        LadderController controller = new LadderController(new InputView() {
            @Override
            public String[] getNames() {
                return "pobi,honux,crong,jk".split(",");
            }

            @Override
            public int getHeight() {
                return 5;
            }
        });
        controller.generateLines(new Random());
        controller.printLines(new StandardOutputView());
    }

    @Test
    public void testFullLadder() {
        LadderController controller = new LadderController(new InputView() {
            @Override
            public String[] getNames() {
                return "a,b,c,d".split(",");
            }

            @Override
            public int getHeight() {
                return 4;
            }
        });
        controller.generateLines(new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        });
        controller.printLines(status -> {
            status.forEach(line ->
                    assertThat(line.toString())
                            .isEqualTo("  |-----|     |-----|"));
            return status;
        });
    }

    @Test
    public void testEmptyLadder() {
        LadderController controller = new LadderController(new InputView() {
            @Override
            public String[] getNames() {
                return "a,b,c".split(",");
            }

            @Override
            public int getHeight() {
                return 3;
            }
        });
        controller.generateLines(new Random() {
            @Override
            public boolean nextBoolean() {
                return false;
            }
        });
        controller.printLines(status -> {
            status.forEach(line ->
                    assertThat(line.toString())
                            .isEqualTo("  |     |     |"));
            return status;
        });
    }
}
