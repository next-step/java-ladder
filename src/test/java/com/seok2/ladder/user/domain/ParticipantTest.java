package com.seok2.ladder.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ParticipantTest {

    @Test
    void throwExceptionLimit() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Participant.of("Gosling"))
            .withMessage("참가자 이름은 5글자를 초과하여 지정할 수 없습니다.");
    }
    @Test
    void throwExceptionBlacklist() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Participant.of("all"))
            .withMessage("허용 되지 않은 참가자 이름입니다.");
    }

    @Test
    void equals() {
        assertThat(Participant.of("Ann")).isEqualTo(Participant.of("Ann"));
    }
}