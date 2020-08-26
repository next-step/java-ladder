package ladder;

import ladder.domain.LadderData;
import ladder.ui.Input;
import ladder.ui.Output;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderDataTest {

    @Test
    public void ladderDataInputTest() {

        String names = "pobi,honux,crong,jk";
        int height = 5;

        LadderData ladderData = new LadderData(when(names, height), output());
        assertEquals(ladderData.getHeight(), height);

        String[] nameArray = names.split(",");
        List<String> nameList = ladderData.getNames();

        assertEquals(nameArray.length, nameList.size());
        
        for (int i = 0; i < nameArray.length; i++) {
            assertEquals(nameArray[i], nameList.get(i));
        }
    }

    @Test
    public void inputNullNames() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LadderData(when(null, 5), output())
        );
    }

    @Test
    public void inputLongNames() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LadderData(when("abcdef,abcde,12345", 5), output())
        );
    }

    @Test
    public void inputMoreThanOneName() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LadderData(when("pobi", 5), output())
        );
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
