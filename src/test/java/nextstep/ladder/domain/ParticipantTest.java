package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @DisplayName("참가자 명이 비어있는 경우 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void createParticipantWithEmptyName(String emptyName) {
        assertThatThrownBy(() -> new Participant(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자 명이 5글자 초과인 경우 예외 발생")
    @Test
    void createParticipantWithLongName() {
        assertThatThrownBy(() -> new Participant("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
