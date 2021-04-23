package ladder.domain.ladder;

import ladder.domain.participant.Participants;
import ladder.domain.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("Ladder 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Participants participants = Participants.of("a,b,c".split(","));
        LadderHeight ladderHeight = LadderHeight.valueOf(5);
        LineGenerateStrategy strategy = () -> true;

        // when
        Ladder ladder = Ladder.from(participants, ladderHeight, strategy);

        // then
        assertThat(ladder).isNotNull();
    }

    @DisplayName("Ladder 인스턴스에 null 입력시 예외처리 여부 테스트")
    @Test
    void 검증_null() {
        // given
        List<Line> nullLines = null;

        assertThatThrownBy(() -> Ladder.from(nullLines))
                .isInstanceOf(LineListNullPointerException.class)
                .hasMessage("List<Line>이 null 입니다.");
    }

}