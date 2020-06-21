package laddergame.domain.game;

import laddergame.domain.game.dto.GameInfoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName("사다리 게임을 실행하고 GameResult를 반환한다.")
    @Test
    void generateGameResult() {
        GameInfoDto gameInfoDto = new GameInfoDto(new String[]{"pobi", "crong", "horox"}, new String[]{"꽝", "2000", "꽝"},
                3);
        LadderGame ladderGame = new LadderGame(gameInfoDto, () -> true);

        assertThat(ladderGame.startGame(gameInfoDto.getPlayers(), gameInfoDto.getPrizes())).isInstanceOf(GameResult.class);
    }
}