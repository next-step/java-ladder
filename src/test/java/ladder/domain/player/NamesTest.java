package ladder.domain.player;

import ladder.domain.common.Height;
import ladder.domain.common.Range;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @Test
    void 이름_일급컬렉션으로_플레이어_일급컬렉션_만들기() {
        String rowNameChan = "chan";
        String rowNamePark = "park";

        Names names = new Names(new String[]{rowNameChan, rowNamePark});
        Players players = names.toPlayers();

        assertThat(players.getPlayers()).hasSize(2);
    }

    @Test
    void 이름_일급컬렉션과_높이로_Range_생성() {
        String rowNameChan = "chan";
        String rowNamePark = "park";
        int height = 2;

        Names names = new Names(new String[]{rowNameChan, rowNamePark});
        Range range = names.makeRange(new Height(height));

        assertThat(range).isEqualTo(new Range(2, new Height(height)));
    }
}