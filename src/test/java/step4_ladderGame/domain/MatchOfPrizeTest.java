package step4_ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4_ladderGame.dto.MatchOfPrizeDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchOfPrizeTest {

    @DisplayName("사다리게임 모든 플레이어의 상품결과를 반환한다.")
    @Test
    void all() {
        Players players = createPlayers();
        MatchOfPrize matchOfPrize = MatchOfPrize.of(new String[]{"1등", "2등", "3등", "4등"}, 4);

        matchOfPrize.match(players);

        MatchOfPrizeDto matchofPrizeDto = matchOfPrize.all();

        assertThat(matchofPrizeDto.getPlayerList()).contains("KT", "LG", "SKT", "CJ");
        assertThat(matchofPrizeDto.getPrizeList()).contains("1등", "2등", "3등", "4등");
    }

    @DisplayName("하나의 플레이어의 상품결과를 반환한다.")
    @Test
    void getPrizeResult() {
        Players players = createPlayers();
        MatchOfPrize matchOfPrize = MatchOfPrize.of(new String[]{"1등", "2등", "3등", "4등"}, 4);
        matchOfPrize.match(players);

        MatchOfPrizeDto matchofPrizeDto = matchOfPrize.getPrizeResult("LG");

        assertThat(matchofPrizeDto.getPlayerList()).contains("LG");
        assertThat(matchofPrizeDto.getPrizeList()).contains("1등");
    }

    Players createPlayers() {
        List<Player> playerList = List.of(Player.of("LG", 0)
                , Player.of("SKT", 1)
                , Player.of("KT", 2)
                , Player.of("CJ", 3));

        return Players.of(playerList);
    }
}
