package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderDataTest {

    @Test
    public void ladderDataInputTest() {

        String names = "pobi,honux,crong,jk";
        int height = 5;

        LadderData ladderData = new LadderData(when(names, height));
        ladderData.inputNames();
        ladderData.inputHeight();

        assertEquals(ladderData.getHeight(), height);

        String[] nameArray = names.split(",");
        String[] nameArrayFromLadderData = ladderData.getNames().getNameArray();

        assertEquals(nameArray.length, nameArrayFromLadderData.length);
        
        for (int i = 0; i < nameArray.length; i++) {
            assertEquals(nameArray[i], nameArrayFromLadderData[i]);
        }
    }

    @Test
    public void inputNullNames() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderData ladderData = new LadderData(when(null, 5));
            ladderData.inputNames();
        });
    }

    @Test
    public void inputLongNames() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderData ladderData = new LadderData(when("abcdef,abcde,12345", 5));
            ladderData.inputNames();
        });
    }

    @Test
    public void inputMoreThanOneName() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderData ladderData = new LadderData(when("pobi", 5));
            ladderData.inputNames();
        });
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
