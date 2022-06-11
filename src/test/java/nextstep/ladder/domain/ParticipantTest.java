package nextstep.ladder.domain;

import nextstep.ladder.exceptions.OutOfMaxNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @Test
    @DisplayName("참가자 이름 허용 길이 초과 시 Exception")
    void outOfMaxNameLength() {
        assertThatExceptionOfType(OutOfMaxNameLengthException.class)
                .isThrownBy(() -> new Participant("TESTING"))
                .withMessage("참가자 이름의 길이는 1 이상 5 이하 이어야 합니다.");
    }

}