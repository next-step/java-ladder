package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ParticipantNamesTest {

    @DisplayName("5명 초과 참가할 경우 예외처리")
    @Test
    void max_participant_size_is_5() {
        Assertions.assertThatThrownBy(
                () -> ParticipantNames.from(Arrays.asList(ParticipantName.from("one"),
                        ParticipantName.from("two"),
                        ParticipantName.from("three"),
                        ParticipantName.from("four"),
                        ParticipantName.from("five"),
                        ParticipantName.from("six"))));
    }
}
