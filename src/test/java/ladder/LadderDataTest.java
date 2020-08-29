package ladder;

import ladder.domain.LadderData;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderDataTest {

    @Test
    public void ladderDataInputTest() {

        String names = "pobi,honux,crong,jk";
        int height = 5;

        LadderData ladderData = new LadderData(WhenUtils.input(names, height), WhenUtils.output());
        assertEquals(ladderData.getHeight(), height);

        String[] nameArray = names.split(",");
        List<String> nameList = ladderData.getPlayerNames();

        assertEquals(nameArray.length, nameList.size());

        for (int i = 0; i < nameArray.length; i++) {
            assertEquals(nameArray[i], nameList.get(i));
        }

        assertEquals(ladderData.getPlayerIndex("pobi"), 0);
        assertEquals(ladderData.getPlayerIndex("honux"), 1);
        assertEquals(ladderData.getPlayerIndex("crong"), 2);
        assertEquals(ladderData.getPlayerIndex("jk"), 3);

        assertEquals(ladderData.getReward(0), "pobi");
        assertEquals(ladderData.getReward(1), "honux");
        assertEquals(ladderData.getReward(2), "crong");
        assertEquals(ladderData.getReward(3), "jk");

        assertThat(ladderData.getRewards().equals(nameList)).isTrue();
    }

    @Test
    public void inputNullNames() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LadderData(WhenUtils.input(null, 5), WhenUtils.output())
        );
    }

    @Test
    public void inputLongNames() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LadderData(WhenUtils.input("abcdef,abcde,12345", 5), WhenUtils.output())
        );
    }

    @Test
    public void inputMoreThanOneName() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LadderData(WhenUtils.input("pobi", 5), WhenUtils.output())
        );
    }
}
