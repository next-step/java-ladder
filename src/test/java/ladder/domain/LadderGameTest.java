package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LadderGameTest {

    @Test
    public void 유저이름_최대길이_테스트() {
        List<String> players = Arrays.asList("1번", "이번타자애오", "삼번타자임니당", "열글자넘기기귀찮구만요");
        LadderGame ladderGame = new LadderGame(players, 4);
        Assertions.assertThat(ladderGame.maxtWidthDrawTimes()).isEqualTo(3);
    }

}