package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantsTest {

    @DisplayName("참가자 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"momo,dd,lala:3", "toto, dodo:2"}, delimiter = ':')
    void of(String input, int expectedNumber) {
        Participants participants = Participants.from(input);

        assertThat(participants.getNumber()).isEqualTo(expectedNumber);
    }

    @DisplayName("참가자 생성 - 이름을 제대로 입력하지 않은 경우, 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void of_name_is_null_empty(String input) {
        String expectedExceptionMessage = LadderExceptionMessage.PARTICIPANT_NEED_MORE_THAN_ONE;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participants.from((input)))
                .withMessage(expectedExceptionMessage);
    }

}
