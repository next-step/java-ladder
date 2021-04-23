package ladder.domain.ladder;

import ladder.domain.participant.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderResultBoardTest {

    @DisplayName("LadderResultBoard 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Map<Participant, String> resultBoard = new HashMap<>();

        // when
        LadderResultBoard ladderResultBoard = LadderResultBoard.of(resultBoard);

        // then
        assertThat(ladderResultBoard).isNotNull();
    }
}