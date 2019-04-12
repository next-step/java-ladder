package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static ladder.domain.Fixture.*;

public class LadderTest {

    @Test
    public void 사다리생성() {
        Ladder result = LADDER;
        
        Assertions.assertThat(result.getLines().size()).isEqualTo(2);
        Assertions.assertThat(result.getLines().get(0).getPoints().size()).isEqualTo(2);
        Assertions.assertThat(result.getLines().get(1).getPoints().size()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리생성_실패() {
          new Ladder(3, 1, GAME_RESULT_LIST);
    }

    @Test
    public void 이동테스트() {
        Line resultLine1 = DISCONNECTED_LINE;
        Line resultLine2 = CONNECTED_LINE;

        Ladder result = new Ladder(Arrays.asList(resultLine1, resultLine2), GAME_RESULT_LIST);

        GameResult moveResult = result.move(0);
        Assertions.assertThat(moveResult.toString()).isEqualTo(WIN_RESULT.toString());

        moveResult = result.move(1);
        Assertions.assertThat(moveResult.toString()).isEqualTo(LOSE_RESULT.toString());
    }
}