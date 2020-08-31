package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.ui.LadderDataInput;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderTest {

    @Test
    public void ladderTest() {

        String names = "pobi,honux,crong,jk";
        int height = 5;

        LadderDataInput ladderDataInput = new LadderDataInput(WhenUtils.input(names, height), WhenUtils.output());
        Ladder ladder = LadderFactory.of(ladderDataInput);

        List<String> nameList = Arrays.asList(names.split(","));

        assertThat(nameList.equals(ladder.getNames())).isTrue();
        assertEquals(ladder.getLadderLinesString().size(), height);

        assertEquals(ladder.getRewardNames(), nameList);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladder.searchReward("a"));

        for (String name : nameList) {
            assertTrue(nameList.contains(ladder.searchReward(name)));
        }

        assertEquals(ladder.searchAllReward().size(), ladderDataInput.getPlayerCount());
    }
}
