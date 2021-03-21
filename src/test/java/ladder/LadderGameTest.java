package ladder;

import ladder.domain.LadderGame;
import ladder.dto.LadderResultDto;
import ladder.dto.LadderGameRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("LadderGame 생성 테스트")
    void create() {
        String[] nameList = new String[]{"pobi", "honux", "crong", "jk", "aa", "ccc"};
        String[] prizeList = new String[]{"100", "300", "500", "0", "2", "꽝"};
        int height = 8;

        LadderGameRequest ladderGameRequest = new LadderGameRequest(nameList, prizeList, height);
        LadderGame ladderGame = new LadderGame(ladderGameRequest);
        LadderResultDto ladderResultDto = ladderGame.ladderBoard();

        assertThat(ladderResultDto.playerNameList()).contains("pobi");
        assertThat(ladderResultDto.playerNameList().size()).isEqualTo(nameList.length);
    }

}
