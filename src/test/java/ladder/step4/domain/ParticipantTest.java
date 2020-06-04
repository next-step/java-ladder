package ladder.step4.domain;

import ladder.step4.exception.ParticipantNameMaximumSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantTest {

    @DisplayName("참여자의 이름이 5글자 이상일 경우 ParticipantNameMaximumSizeException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef", "aaaaaa"})
    void 참여자_이름_검증(String name) {
        assertThatExceptionOfType(ParticipantNameMaximumSizeException.class)
            .isThrownBy(() -> Participant.valueOf(name));
    }

    @DisplayName("객체를 재사용하고 있는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "bb", "cc"})
    void 객체_재사용_검증(String name) {
        assertEquals(true, Participant.valueOf(name) == Participant.valueOf(name));
    }
}
