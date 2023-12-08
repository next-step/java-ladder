package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantTest {
    @DisplayName("참가자가 5글자를 넘는다.")
    @Test
    void 참가자_최대_글자_초과() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Participant("abcdefg"))
                .withMessage("참가자 이름은 5글자를 넘을 수 없습니다.");
    }
}
