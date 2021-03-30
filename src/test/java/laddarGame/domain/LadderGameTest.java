package laddarGame.domain;

import laddarGame.dto.PlayerDto;
import laddarGame.dto.PlayersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderGameTest {

    @DisplayName("생성된 Players를 PlayersDto로 반환한다.")
    @Test
    void createDto() {
        LadderGame ladderGame = new LadderGame("LG,SKT", 2);
        PlayersDto playersDto = ladderGame.playersDto();

        assertEquals(new PlayerDto("LG", 0), playersDto.getPlayerList().get(0));
        assertEquals(new PlayerDto("SKT", 1), playersDto.getPlayerList().get(1));
    }

}