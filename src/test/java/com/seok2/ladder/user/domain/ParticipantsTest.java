package com.seok2.ladder.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    void throwException() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Participants.of("Ann"))
            .withMessage("최소 2명의 참가자를 입력해주세요.");
    }

    @Test
    void size() {
        assertThat(Participants.of("Ann, Pray").size()).isEqualTo(2);
    }
}