package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    @DisplayName("2가지의 생성자 동작 확인")
    void create() {
        assertThat(new Participants(new String[]{"p1", "p2"})).isEqualTo(new Participants(List.of("p1", "p2")));
    }

    @Test
    @DisplayName("참여자가 2명 미만인 경우 테스트 - 예외 발생")
    void invalid_name_size() {
        assertThatThrownBy(() -> new Participants(new String[]{"p123"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participants.TOO_FEW_PARTICIPANTS_MESSAGE);
    }
}
