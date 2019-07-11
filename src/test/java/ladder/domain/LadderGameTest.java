package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("LadderGame 생성 검증")
    void of() {

        int ladderHeight = 5;

        LadderGame ladderGame = LadderGame.of(GameInfo.of(new Participants("a,b,c,d"), new Goals("1,2,3,4")), ladderHeight);
        assertThat(ladderGame.getLines().getLines()).hasSize(ladderHeight);
    }
}