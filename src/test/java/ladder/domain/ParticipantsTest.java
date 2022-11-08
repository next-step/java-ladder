package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    @DisplayName("잘못된 생성 - 빈 배열")
    @Test
    void invalid() {
        assertThatThrownBy(() -> new Participants(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자는 최소 1명 이상이여야 합니다.");
    }

    @DisplayName("생성")
    @Test
    void create() {
        Participants participants = new Participants(List.of(new Participant("woody")));
        assertThat(participants).isEqualTo(new Participants(List.of(new Participant("woody"))));
    }
}
