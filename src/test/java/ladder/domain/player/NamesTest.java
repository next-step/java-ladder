package ladder.domain.player;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @Test
    void 이름_일급컬렉션으로_플레이어_일급컬렉션_만들기() {
        String rowNameChan = "chan";
        String rowNamePark = "park";

        Names names = new Names(Arrays.asList(new Name(rowNameChan), new Name(rowNamePark)));
        Players players = names.toPlayers();

        assertThat(players.getPlayers()).hasSize(2);
    }
}