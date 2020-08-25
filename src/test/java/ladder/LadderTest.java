package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderData;
import ladder.ui.Input;
import ladder.ui.Output;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {

    @Test
    public void ladderTest() {

        LadderData ladderData = new LadderData(when("pobi,honux,crong,jk", 5), output());
        ladderData.inputNames();
        ladderData.inputHeight();

        Ladder ladder = new Ladder(ladderData);
//        ladder.makeLadder();
        ladder.getParticipants();
        ladder.getLadderString();
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

    private Output output() {
        return new Output() {
            @Override
            public void print(String line) {

            }

            @Override
            public void print(List<String> lineList) {

            }

            @Override
            public void printMultiLine(List<String> lineList) {

            }
        };
    }
}
