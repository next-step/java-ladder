package ladder.domain;

import ladder.exception.InvalidParticipantsSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    @DisplayName("잘못된 생성 - 빈 배열")
    @Test
    void invalid() {
        assertThatThrownBy(() -> new Participants(Collections.emptyList()))
                .isInstanceOf(InvalidParticipantsSizeException.class);
    }
}
