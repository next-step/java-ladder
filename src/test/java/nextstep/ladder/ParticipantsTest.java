package nextstep.ladder;

import nextstep.ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantsTest {
    @Test
    @DisplayName("중복된 참가자 이름을 사용 한 경우 throw Exception")
    void duplicateNameTest() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> Participants.from(Arrays.asList("name1", "name1", "name2")))
                .withMessage(Participants.DUPLICATE_NAME_EXIST_ERR_MSG);
    }
}
