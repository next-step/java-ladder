package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantNameTest {

    @Test
    @DisplayName("[요구사항 1] 사다리 게임 참여자의 이름이 5자를 초과할 경우 throw IllegalArgumentException")
    void 요구사항_1() {
        // given
        String participantName = "Arirang";

        // then
        Assertions.assertThatThrownBy(() -> new ParticipantName(participantName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 게임에 참여하는 사람의 이름은 최대 5글자입니다.");
    }
}
