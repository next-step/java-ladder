package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LadderLinesTest {

    @DisplayName("플레이어 마지막 위치 계산하는 메소드 테스트 - 모든 사다리가 연결이 되지 않았을 경우")
    @Test
    void find_last_player_position() {
        int playerCount = 4;
        int ladderHeight = 4;

        LadderLines ladderLines = new LadderLines(playerCount, ladderHeight, () -> false);

        for(int i = 0; i < playerCount; i++) {
            assertThat(ladderLines.findLastPlayerPosition(i))
                    .isEqualTo(i);
        }
    }
}