package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantsTest {

    @DisplayName("참가자 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"momo,dd,lala:3", "toto, dodo:2"}, delimiter = ':')
    void of(String input, int expectedNumber) {
        Participants participants = Participants.of(input);

        assertThat(participants.getNumber()).isEqualTo(expectedNumber);
    }

    @DisplayName("참가자 생성 - 참가자 1명인 경우, 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "nana", "나나"})
    void of_name_is_one(String input) {
        String expectedExceptionMessage = LadderExceptionMessage.PARTICIPANT_NEED_MORE_THAN_ONE;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participants.of(input))
                .withMessage(expectedExceptionMessage);
    }

    @DisplayName("참가자 생성 - 5자 이상 이름 입력 시, 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"dundun,tt", "홍,안녕하세요빰빰"})
    void of_name_too_long(String input) {
        String expectedExceptionMessage = LadderExceptionMessage.PARTICIPANT_NAME_TOO_LONG;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participants.of(input))
                .withMessage(expectedExceptionMessage);
    }
}
