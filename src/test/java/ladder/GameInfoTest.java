package ladder;

import ladder.domain.Goals;
import ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameInfoTest {

    @Test
    @DisplayName("GameInfo 객체생성 시 참가자 수와 결과 수가 다르다면 exception 발생")
    void isNotEqualsParticipantsCountAndGoalsCount() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameInfo.of(new Participants("a,b,c,d"), new Goals("1")));
    }
}