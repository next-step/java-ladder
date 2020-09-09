package ladder.ui;

import java.util.List;

import org.junit.jupiter.api.Test;

import ladder.WhenUtils;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderDataInputTest {

    @Test
    public void ladderDataInputTest() {

        String names = "pobi,honux,crong,jk";
        int height = 5;

        LadderDataInput ladderDataInput = new LadderDataInput(WhenUtils.input(names, height), WhenUtils.output());
        assertEquals(ladderDataInput.getHeight(), height);

        String[] nameArray = names.split(",");
        List<String> nameList = ladderDataInput.getPlayerNames();

        assertEquals(nameArray.length, nameList.size());

        for (int i = 0; i < nameArray.length; i++) {
            assertEquals(nameArray[i], nameList.get(i));
            assertEquals(ladderDataInput.getPlayerIndex(nameArray[i]), i);
            assertEquals(ladderDataInput.getRewards().get(i), nameArray[i]);
        }

        assertEquals(ladderDataInput.getRewards().getNames(), nameList);
    }

    @Test
    public void inputNullNames() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LadderDataInput(WhenUtils.input(null, 5), WhenUtils.output())
        );
    }

    @Test
    public void inputLongNames() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LadderDataInput(WhenUtils.input("abcdef,abcde,12345", 5), WhenUtils.output())
        );
    }

    @Test
    public void inputMoreThanOneName() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LadderDataInput(WhenUtils.input("pobi", 5), WhenUtils.output())
        );
    }
}
