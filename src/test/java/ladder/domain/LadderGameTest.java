package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("Element 중 가장 큰 이름 크기의 값을 반환한다.")
    void maxNameSize() {
        Elements players = Elements.createPlayers("tom, tommy, paul");
        Elements results = Elements.createResults("벌칙입니다, 10000, 꽝");
        LadderGame ladderGame = new LadderGame(players, results, new Height(5));

        assertThat(ladderGame.maxNameSize()).isEqualTo(10);
    }
}