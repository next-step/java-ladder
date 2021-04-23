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

    @DisplayName("LadderResultBoard 인스턴스 특정 사람에 대한 결과 반환 테스트")
    @Test
    void 반환_특정사람() {
        // given
        Map<Participant, String> resultBoard = new HashMap<>();
        String expected = "성공";
        resultBoard.put(Participant.of("userA"), "실패");
        resultBoard.put(Participant.of("userB"), expected);
        resultBoard.put(Participant.of("userC"), "실패");

        // when
        LadderResultBoard ladderResultBoard = LadderResultBoard.of(resultBoard);
        String actual = ladderResultBoard.findResultByParticipant(Participant.of("userB"));

        // then
        assertThat(actual).isEqualTo(expected);
    }

}