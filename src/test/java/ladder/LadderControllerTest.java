package ladder;

import org.junit.jupiter.api.Test;

import ladder.controller.LadderController;
import ladder.ui.Input;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class LadderControllerTest {

    @Test
    public void ladderControllerBuildFail() {

        assertThatNullPointerException().isThrownBy(() -> LadderController.builder()
                                                                          .build());
    }

    @Test
    public void ladderControllerPrintResultFail() {

        LadderController ladderController = LadderController.builder()
                                                            .input(WhenUtils.input("a,b,c", 5))
                                                            .output(WhenUtils.output())
                                                            .build();

        ladderController.printLadder();
        assertThatIllegalArgumentException().isThrownBy(() -> ladderController.printResult());
    }

    @Test
    public void ladderControllerSuccess() {

        Input input = new Input() {

            private int callCount = 0;

            @Override
            public int nextInt() {
                return 5;
            }

            @Override
            public String nextLine() {

                callCount++;

                if (callCount <= 2) {
                    return "a,b,c";
                }

                if (callCount <= 4) {
                    return "all";
                }

                if (callCount <= 5) {
                    return "a";
                }

                return "exit";
            }
        };

        LadderController ladderController = LadderController.builder()
                                                            .input(input)
                                                            .output(WhenUtils.output())
                                                            .build();

        ladderController.printLadder();
        ladderController.printResult();
    }
}
