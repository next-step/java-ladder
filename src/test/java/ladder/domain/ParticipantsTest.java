package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    @Test
    @DisplayName("빈 값을 할당하는 경우 Participants 객체를 생성하는데 실패한다.")
    void create_with_empty_value() {
        assertThatThrownBy(() -> new Participants("")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("참여자가 한 사람 이하인 경우 Participants 객체를 생성하는데 실패한다.")
    void create_with_one_person() {
        assertThatThrownBy(() -> new Participants("jordy")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("두 사람 이상 참여해야 합니다.");
    }

    @Test
    @DisplayName("size 메소드는 참여자의 수를 반환한다.")
    void size() {
        Participants participants = new Participants("jordy,penda,kero");
        assertThat(participants.size()).isEqualTo(3);
    }
}
