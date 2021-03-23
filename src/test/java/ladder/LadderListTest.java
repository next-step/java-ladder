package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderList;
import ladder.domain.LadderNumber;
import ladder.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderListTest {

    @Test
    @DisplayName("ladderNumber에 맞는 prize가 선택되는지 테스트")
    void prize() {
        LadderNumber ladderNumberToFind = new LadderNumber(0);
        Prize expectedPrize = new Prize("100");
        List<Ladder> ladderRawList = Arrays.asList(new Ladder(ladderNumberToFind,expectedPrize),new Ladder(1,"200"));
        LadderList ladderList = new LadderList(ladderRawList);

        assertThat(ladderList.prize(ladderNumberToFind)).isEqualTo(expectedPrize);
    }
}
