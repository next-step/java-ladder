package ladder.domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ladder.domain.Position;
import ladder.exception.LadderGameException;
import org.junit.jupiter.api.Test;

class ResultPrizeTest {

    private final String[] userNames = new String[]{"a", "b", "c"};
    private final String[] userNames2 = new String[]{"a", "b"};
    private final String[] prizeNames = new String[]{"1", "2"};

    @Test
    void 객체_생성_실패_테스트() {
        assertThrows(LadderGameException.class, () -> new ResultPrize(prizeNames, userNames.length));
    }

    @Test
    void getResultByResultPositionTest() {
        ResultPrize resultPrize = new ResultPrize(prizeNames, userNames2.length);
        Position secondPosition = new Position(1);
        assertThat(resultPrize.getResultByResultPosition(secondPosition)).isEqualTo(prizeNames[secondPosition.getPosition()]);
    }

}