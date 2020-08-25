package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderData;
import ladder.ui.Input;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    public void ladderTest() {

        LadderData ladderData = new LadderData(when("pobi,honux,crong,jk", 5));
        ladderData.inputNames();
        ladderData.inputHeight();

        Ladder ladder = new Ladder(ladderData);
        ladder.makeLadder();
        ladder.printLadder();
    }

    private Input when(String names, int height) {
        return new Input() {
            @Override
            public int nextInt() {
                return height;
            }

            @Override
            public String nextLine() {
                return names;
            }
        };
    }
}
