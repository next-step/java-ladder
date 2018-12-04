package ladder2.model;

import org.junit.Test;

import static ladder2.model.ParticipantTest.DEFAULT_PARTICIPANT;
import static ladder2.model.ResultItemTest.DEFAULT_RESULT_ITEM;
import static org.assertj.core.api.Assertions.assertThat;

public class GameResultItemTest {
    public static final GameResultItem DEFAULT_GAME_RESULT_ITEM = new GameResultItem(DEFAULT_PARTICIPANT, DEFAULT_RESULT_ITEM);

    @Test
    public void 생성() {
        assertThat(DEFAULT_GAME_RESULT_ITEM).isNotNull();
    }

    @Test
    public void 참가자_일치_여부() {
        assertThat(DEFAULT_GAME_RESULT_ITEM.isMatchParticipant("test")).isTrue();
    }

    @Test
    public void 참가자_이름() {
        assertThat(DEFAULT_GAME_RESULT_ITEM.getName()).isEqualTo("test");
    }

    @Test
    public void 결과_이름() {
        assertThat(DEFAULT_GAME_RESULT_ITEM.getResultName()).isEqualTo("3000");
    }
}