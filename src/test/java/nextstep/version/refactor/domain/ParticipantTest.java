package nextstep.version.refactor.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @DisplayName("이름은 5글자 미만이다.")
    @Test
    void createParticipant() {
        assertThatThrownBy(() -> new Participant("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
