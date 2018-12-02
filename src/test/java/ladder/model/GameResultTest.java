package ladder.model;

import org.junit.Test;

import static ladder.model.ParticipantTest.DEFAULT_PARTICIPANT;
import static ladder.model.ResultItemTest.DEFAULT_RESULT_ITEM;
import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    public void 생성() {
        assertThat(new GameResult()).isNotNull();
    }

    @Test
    public void 결과_추가() {
        GameResult gameResult = new GameResult();
        gameResult.addResult(DEFAULT_PARTICIPANT, DEFAULT_RESULT_ITEM);
        assertThat(gameResult.getGameResultItems().size()).isEqualTo(1);
    }

    @Test
    public void 참가자_이름으로_결과_조회() {
        GameResult gameResult = new GameResult();
        gameResult.addResult(DEFAULT_PARTICIPANT, DEFAULT_RESULT_ITEM);
        assertThat(gameResult.getResult("test").getName()).isEqualTo("test");
    }
}