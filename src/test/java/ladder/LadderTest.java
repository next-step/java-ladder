package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderData;
import ladder.ui.Input;
import ladder.ui.Output;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @Test
    public void ladderTest() {


        String names = "pobi,honux,crong,jk";
        int height = 5;

        LadderData ladderData = new LadderData(when(names, height), output());
//        ladderData.inputNames();
//        ladderData.inputHeight();

        Ladder ladder = new Ladder(ladderData);

        List<String> nameList = Arrays.asList(names.split(","));

        for (int i = 0; i < nameList.size(); i++) {
            assertEquals(nameList.get(i), ladder.getNames().get(i));
        }

        assertEquals(ladder.getLadderString().size(), height);
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
