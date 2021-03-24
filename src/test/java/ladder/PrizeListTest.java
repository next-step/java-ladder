package ladder;

import ladder.domain.Position;
import ladder.domain.Prize;
import ladder.domain.PrizeList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeListTest {

    @Test
    @DisplayName("position에 맞는 prize가 선택되는지 테스트")
    void prize() {
        Position positionToFind = new Position(0);
        Prize expectedPrize = new Prize("100");
        List<Prize> prizeRawList = Arrays.asList(expectedPrize, new Prize("200"));
        PrizeList prizeList = new PrizeList(prizeRawList);

        assertThat(prizeList.prize(positionToFind)).isEqualTo(expectedPrize);
    }
}
