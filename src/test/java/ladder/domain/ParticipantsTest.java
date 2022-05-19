package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @DisplayName("문자열 형태의 참여자들 이름을 인자로 받는 정적 팩토리 메서드 테스트")
    @Test
    void from() {
        String input = "pobi,honux,crong,jk";
        assertThat(Participants.from(input).count()).isEqualTo(4);
    }
}

