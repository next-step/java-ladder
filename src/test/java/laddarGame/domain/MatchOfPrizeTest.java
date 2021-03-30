package laddarGame.domain;

import laddarGame.dto.MatchOfPrizeDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchOfPrizeTest {

    @DisplayName("사다리게임 모든 플레이어의 상품결과를 반환한다.")
    @Test
    void all() {
        List<String> players = createPlayers();
        MatchOfPrize matchOfPrize = new MatchOfPrize("1등,2등,3등,4등");
        matchOfPrize.match(players);

        MatchOfPrizeDto matchofPrizeDto = matchOfPrize.all();

        assertThat(matchofPrizeDto.getPlayerList()).contains("KT", "LG", "SKT", "T1");
        assertThat(matchofPrizeDto.getPrizeList()).contains("1등", "2등", "3등", "4등");
    }

    @DisplayName("하나의 플레이어의 상품결과를 반환한다.")
    @Test
    void getPrizeResult() {
        List<String> players = createPlayers();
        MatchOfPrize matchOfPrize = new MatchOfPrize("1등,2등,3등,4등");
        matchOfPrize.match(players);

        MatchOfPrizeDto matchofPrizeDto = matchOfPrize.getPrizeResult("LG");

        assertThat(matchofPrizeDto.getPlayerList()).contains("LG");
        assertThat(matchofPrizeDto.getPrizeList()).contains("1등");
    }

    List<String> createPlayers() {
        return List.of("LG", "SKT", "KT", "T1");
    }

}
