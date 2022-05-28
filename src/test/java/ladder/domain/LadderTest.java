package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 높이만큼 라인이 생성된다.")
    void totalLines() {
        assertThat(new Ladder(new Height(5), Elements.createPlayers("tom, paul, anna")).totalLines()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 게임을 실행이 모두 완료되면 Players의 Position Type은 모두 FIXED 로 변경된다.")
    void start() {
        Elements players = Elements.createPlayers("Tom, Paul");
        Ladder ladder = new Ladder(new Height(5), players);

        ladder.start(players);

        assertThat(players.containUnfixedPosition()).isFalse();
    }
}