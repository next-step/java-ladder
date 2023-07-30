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
}
