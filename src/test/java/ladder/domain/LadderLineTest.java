package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    Players players;

    @BeforeEach
    void setup() {
        players = Players.register("a,b,c,d,e");
    }

    @Test
    @DisplayName("사용자 수에 따른 라인을 생성한다.")
    void ladderLineInit() {
        LadderLine ladderLine = LadderLine.init(players);
        assertThat(ladderLine.size()).isEqualTo(players.size());
    }
}
