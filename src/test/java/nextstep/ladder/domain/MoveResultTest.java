package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveResultTest {

    @Test
    public void get_WinningItem_Index_테스트() throws Exception {
        // given
        MoveResult moveResult = new MoveResult();

        // when
        moveResult.put(0,2);

        // then
        assertThat(moveResult.getWinningItemIndex(0)).isEqualTo(2);
    }

    @Test
    public void 당첨_항목_플레이어_맵핑_테스트() throws Exception {
        // given
        MoveResult moveResult = new MoveResult();
        moveResult.put(0,1);
        moveResult.put(1,2);
        moveResult.put(2,0);

        // when
        LadderGameResult ladderGameResult = moveResult.map(new Players("test", "test2", "test3"), new WinningItems(3, "10", "20", "30"));

        // then
        assertThat(ladderGameResult.toString()).contains("test: 20\ntest2: 30\ntest3: 10");
    }
}
