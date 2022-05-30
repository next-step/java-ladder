package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        Positions players = Positions.createPlayers(new String[]{"tom", "paul", "anna"});
        Positions results = Positions.createResults(new String[]{"벌칙입니다", "10000", "꽝"});
        Height height = new Height(5);
        ladder = new Ladder(height, new PositionGroup(players, results));
    }

    @Test
    @DisplayName("사다리 높이만큼 라인이 생성된다.")
    void totalLines() {
        assertThat(ladder.totalLines()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 게임을 실행이 모두 완료되면 Players의 Position Type은 모두 FIXED 로 변경된다.")
    void start() {
        ladder.start();
        assertThat(ladder.playerPositions().containUnfixedPosition()).isFalse();
    }

    @Test
    @DisplayName("Positions 중 가장 큰 이름 크기의 값을 반환한다.")
    void maxNameSize() {
        assertThat(ladder.maxNameSize()).isEqualTo(10);
    }
}