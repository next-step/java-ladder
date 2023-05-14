package ladder.domain;

import ladder.strategy.RandomLadderStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


@DisplayName("사다리 게임 테스트")
class LadderGameTest {

    @DisplayName("참여자의 인원수와 사다리 넓이가 같지 않으면 예외가 발생한다")
    @Test
    void validateLadderGameTest() {
        String participantNames = "aaa, bbb, ccc";
        Participants participants = new Participants(participantNames);
        Ladder ladder = new Ladder(4, 5, new RandomLadderStrategy());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(participants, ladder))
                .withMessage("사다리의 너비와 참가자 수가 일치하지 않습니다");
    }
}
