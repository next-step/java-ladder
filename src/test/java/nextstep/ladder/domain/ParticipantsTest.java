package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantsTest {
    @DisplayName("빈문자열 입력")
    @Test
    void 빈_문자열_입력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Participants(""))
                .withMessage("참가자를 입력해주세요.");
    }

    @DisplayName("참가자 부족")
    @Test
    void 참가자_부족() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Participants("abcd"))
                .withMessage("참가자가 부족합니다.");
    }
}
