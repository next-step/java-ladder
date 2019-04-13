package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static ladder.domain.Fixture.*;

public class LadderGameTest {

    @Test
    public void 유저이름_최대길이_테스트() {
        List<String> players = Arrays.asList("1번", "이번타자애오", "삼번타자임니당", "열글자넘기기귀찮구만요");
        
        LadderGame ladderGame = new LadderGame(players, LADDER);
        Assertions.assertThat(ladderGame.maxWidthDrawTimes()).isEqualTo(3);
    }

    @Test
    public void 플레이_결과() {
        List<String> players = PLAYER_LIST;

        Line resultLine1 = DISCONNECTED_LINE;
        Line resultLine2 = CONNECTED_LINE;
        
        Ladder result = new Ladder(Arrays.asList(resultLine1, resultLine2), GAME_RESULT_LIST);

        LadderGame ladderGame = new LadderGame(players, result);
        Assertions.assertThat(ladderGame.play()).isEqualTo(PLAY_RESULTS);
    }

}