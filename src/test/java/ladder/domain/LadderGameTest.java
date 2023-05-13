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

    @DisplayName("사다리 게임에 참여한 인원 중 가장 긴 이름의 길이를 구할수 있다 ")
    @Test
    void calculateMaxNameLengthTest() {
        String participantNames = "a, bb, ccc, dddd";
        Participants participants = new Participants(participantNames);
        Ladder ladder = new Ladder(4, 5, new RandomLadderStrategy());
        LadderGame ladderGame = new LadderGame(participants, ladder);
        int maxNameLength = ladderGame.calculateMaxNameLength();
        assertThat(maxNameLength).isEqualTo(4);
    }

}