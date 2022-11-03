package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ParticipantNamesTest {

    @DisplayName("참여자 수가 0명이면 예외 처리")
    @Test
    void participant_count_not_zero() {
        List<ParticipantName> blankList = new ArrayList<>();
        Assertions.assertThatThrownBy(() -> ParticipantNames.from(blankList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
